package com.orbit.service;

import com.orbit.constants.LeaveStatus;
import com.orbit.mapper.DtoMapper;
import com.orbit.service.dto.request.LeaveRequest;
import com.orbit.mapper.EntityMapper;
import com.orbit.service.dto.models.Holiday;
import com.orbit.service.dto.models.Leave;
import com.orbit.repository.HolidayRepository;
import com.orbit.repository.LeaveRepository;
import com.orbit.service.dto.response.LeaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;
    @Autowired
    private HolidayRepository holidayRepository;
    @Autowired
    private EntityMapper entityMapper;
    @Autowired
    private DtoMapper dtoMapper;

    List<Holiday> holidayList;

    public LeaveRequest save(LeaveRequest leaveRequest) {
        if(leaveRequest.getEndDate().compareTo(leaveRequest.getStartDate()) < 0)
        {
            throw new UnsupportedOperationException("End date is before start date.");
        }
        Boolean checkPreviouslyApply=checkLeaveApplied(leaveRequest);
        if(checkPreviouslyApply == true) {
            throw new UnsupportedOperationException("Already Applied");
        }
        double numOfLeaves = getActualNumberOfLeaves(leaveRequest);
        leaveRequest.setNumberOfLeaves(numOfLeaves);

        leaveRequest.setLeaveStatus(LeaveStatus.Applied.toString());
        leaveRequest.setCreationTime(LocalDate.now());
        leaveRequest.setUpdateTime(LocalDate.now());
        return entityMapper.toLeaveDto(leaveRepository.save(dtoMapper.toLeaveEntity(leaveRequest)));

    }

    public LeaveResponse findLeaveById(Long leaveId) {
        try
        {
            Leave leave = leaveRepository.findById(leaveId).get();
            return new LeaveResponse(HttpStatus.OK, entityMapper.toLeaveDto(leave));
        }
        catch (Exception e)
        {
            return new LeaveResponse(HttpStatus.NOT_FOUND);
        }
    }

    public List<LeaveRequest> findAllLeave() {
        return entityMapper.toLeaveDtoList(leaveRepository.findAll());
    }

    public List<LeaveRequest> findAllLeaveByStatus(Long employeeId, String leaveStatus) {
        return entityMapper.toLeaveDtoList(leaveRepository.findAllByLeaveStatus(employeeId, leaveStatus.toString()));
    }

    public List<LeaveRequest> findAllLeaveByManagerId(Long managerId) {
        return entityMapper.toLeaveDtoList(leaveRepository.findAllByManagerId(managerId));
    }

    public List<LeaveRequest> findAllLeaveByStatusForManager(Long managerId, LeaveStatus leaveStatus) {
        return entityMapper.toLeaveDtoList(leaveRepository.findAllByLeaveForManagerByStatus(managerId, leaveStatus.toString()));
    }

    public Long findLeaveCountByStatusForManager(Long managerId, LeaveStatus leaveStatus) {
        return leaveRepository.getLeaveCountByStatusForManager(managerId, leaveStatus.toString());
    }

    public List<LeaveRequest> findAllLeaveByEmployeeId(Long employeeId) {
        return entityMapper.toLeaveDtoList(leaveRepository.findAllByEmployeeId(employeeId, LocalDate.now().minusMonths(3)));
    }

    public LeaveResponse update(List<LeaveRequest> leaveRequestList) {
        try
        {   List<LeaveRequest> leaveRequestList1 = new ArrayList<>();

            leaveRequestList.forEach(leave -> {
                Leave getLeave = leaveRepository.findById(leave.getId()).get();
                getLeave.setLeaveStatus(leave.getLeaveStatus());
                getLeave.setRemark(leave.getRemark());
                getLeave.setUpdateTime(LocalDate.now());
                leaveRepository.save(getLeave);

                leaveRequestList1.add(entityMapper.toLeaveDto(getLeave));
            });


            return new LeaveResponse(HttpStatus.OK, leaveRequestList1);
        }
        catch (Exception ex)
        {
            return new LeaveResponse(HttpStatus.NOT_FOUND);
        }
    }

    public LeaveResponse deleteLeave(Long leaveId) {
        try
        {
            Leave leave = leaveRepository.findById(leaveId).get();
            leaveRepository.delete(leave);
            return new LeaveResponse(HttpStatus.ACCEPTED);
        }
        catch (Exception ex) {
            return new LeaveResponse(HttpStatus.NOT_FOUND);
        }
    }


    private double getActualNumberOfLeaves(LeaveRequest leaveRequest)
    {
        holidayList = holidayRepository.findAll();

        int holidayCount = 0;
        for(Holiday holiday : holidayList)
        {
            if( holiday.getDate().compareTo(leaveRequest.getStartDate()) >= 0 &&
                    holiday.getDate().compareTo(leaveRequest.getEndDate()) <= 0)
            {
                holidayCount++;
            }
        }

        return (double) ChronoUnit.DAYS.between(leaveRequest.getStartDate(), leaveRequest.getEndDate())
                + 1 - holidayCount;
    }

    private Boolean checkLeaveApplied(LeaveRequest leaveRequest){
        final boolean checkApplied[] = new boolean[]{false};
        int count=0;
        List<LocalDate> totalDates = new ArrayList<>();
        Leave leave1=new Leave();
        leave1.setStartDate(leaveRequest.getStartDate());
        leave1.setEndDate(leaveRequest.getEndDate());
        while (!leave1.getStartDate().isAfter(leave1.getEndDate())) {
            totalDates.add(leave1.getStartDate());
            leave1.setStartDate(leave1.getStartDate().plusDays(1));
        }
        List<Leave> EmpleaveData=leaveRepository.findAllByEmpId(leaveRequest.getEmployeeId());
        EmpleaveData.forEach(emp->{
            if(emp.getLeaveStatus().equals(LeaveStatus.Applied.toString()) || emp.getLeaveStatus().equals(LeaveStatus.Approved.toString()))
            {
                totalDates.forEach(dt->{
                    if(emp.getStartDate().compareTo(dt) * emp.getEndDate().compareTo(dt) <= 0){
                        checkApplied[0] = true;
                    }
                    if(emp.getStartDate().equals(dt) || emp.getEndDate().equals(dt)){
                        checkApplied[0] = true;
                    }
                });
            }
        });
        return checkApplied[0];
    }


}
