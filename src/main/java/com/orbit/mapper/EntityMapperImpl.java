package com.orbit.mapper;


import com.orbit.service.dto.models.*;
import com.orbit.service.dto.request.*;
import org.springframework.stereotype.Component;
import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(value = "org.mapstruct.ap.MappingProcessor")
@Component
public class EntityMapperImpl implements EntityMapper {

    @Override
    public EmployeeRequest toEmployeeDto(Employee employee) {
        if(employee == null) {
            return null;
        }

        EmployeeRequest employeeRequest = new EmployeeRequest();

        employeeRequest.setId(employee.getId());
        employeeRequest.setEmployeeName(employee.getEmployeeName());
        employeeRequest.setManagerId(employee.getManagerId());
        employeeRequest.setJoiningDate(employee.getJoiningDate());
        employeeRequest.setUserId(employee.getUserId());
        employeeRequest.setLeaveBalance(employee.getLeaveBalance());

        return employeeRequest;
    }

    @Override
    public HolidayRequest toHolidayDto(Holiday holiday) {
        if(holiday == null) {
            return null;
        }

        HolidayRequest holidayRequest = new HolidayRequest();

        holidayRequest.setId(holiday.getId());
        holidayRequest.setDate(holiday.getDate());
        holidayRequest.setRegion(holiday.getRegion());
        holidayRequest.setDescription(holiday.getDescription());
        holidayRequest.setCountry(holiday.getCountry());

        return holidayRequest;
    }

    @Override
    public List<HolidayRequest> toHolidayDtoList(List<Holiday> holidayList) {
        if(holidayList == null) {
            return null;
        }

        List<HolidayRequest> holidayRequestsList = new ArrayList<>();

        for(Holiday holiday: holidayList) {

            HolidayRequest holidayRequest = new HolidayRequest();

            holidayRequest.setId(holiday.getId());
            holidayRequest.setDate(holiday.getDate());
            holidayRequest.setRegion(holiday.getRegion());
            holidayRequest.setDescription(holiday.getDescription());
            holidayRequest.setCountry(holiday.getCountry());

            holidayRequestsList.add(holidayRequest);
        }

        return holidayRequestsList;
    }

    @Override
    public LeaveRequest toLeaveDto(Leave leave) {
        if(leave == null) {
            return null;
        }

        LeaveRequest leaveRequest = new LeaveRequest();

        leaveRequest.setId(leave.getId());
        leaveRequest.setEmployeeId(leave.getEmployeeId());
        leaveRequest.setManagerId(leave.getManagerId());
        leaveRequest.setStartDate(leave.getStartDate());
        leaveRequest.setEndDate(leave.getEndDate());
        leaveRequest.setNumberOfLeaves(leave.getNumberOfLeaves());
        leaveRequest.setLeaveStatus(leave.getLeaveStatus());
        leaveRequest.setCreationTime(leave.getCreationTime());
        leaveRequest.setUpdateTime(leave.getUpdateTime());
        leaveRequest.setRemark(leave.getRemark());
        leaveRequest.setLeaveType(leave.getLeaveType());

        return leaveRequest;
    }

    @Override
    public List<LeaveRequest> toLeaveDtoList(List<Leave> leaveList) {
        if(leaveList == null) {
            return null;
        }

        List<LeaveRequest> leaveRequestList = new ArrayList<>();

        for(Leave leave: leaveList) {

            LeaveRequest leaveRequest = new LeaveRequest();

            leaveRequest.setId(leave.getId());
            leaveRequest.setEmployeeId(leave.getEmployeeId());
            leaveRequest.setManagerId(leave.getManagerId());
            leaveRequest.setStartDate(leave.getStartDate());
            leaveRequest.setEndDate(leave.getEndDate());
            leaveRequest.setNumberOfLeaves(leave.getNumberOfLeaves());
            leaveRequest.setLeaveStatus(leave.getLeaveStatus());
            leaveRequest.setCreationTime(leave.getCreationTime());
            leaveRequest.setUpdateTime(leave.getUpdateTime());
            leaveRequest.setRemark(leave.getRemark());
            leaveRequest.setLeaveType(leave.getLeaveType());

            leaveRequestList.add(leaveRequest);
        }

        return leaveRequestList;
    }

    @Override
    public LeaveTypeRequest toLeaveTypeDto(LeaveType leaveType) {
        if(leaveType == null) {
            return null;
        }

        LeaveTypeRequest leaveTypeRequest = new LeaveTypeRequest();

        leaveTypeRequest.setId(leaveType.getId());
        leaveTypeRequest.setLeaveType(leaveType.getLeaveType());
        leaveTypeRequest.setNumOfLeaves(leaveType.getNumOfLeaves());

        return leaveTypeRequest;
    }

    @Override
    public List<LeaveTypeRequest> toLeaveTypeDtoList(List<LeaveType> leaveTypeList) {
        if(leaveTypeList == null) {
            return null;
        }

        List<LeaveTypeRequest> leaveTypeRequestList = new ArrayList<>();

        for(LeaveType leaveType: leaveTypeList) {
            LeaveTypeRequest leaveTypeRequest = new LeaveTypeRequest();

            leaveTypeRequest.setId(leaveType.getId());
            leaveTypeRequest.setLeaveType(leaveType.getLeaveType());
            leaveTypeRequest.setNumOfLeaves(leaveType.getNumOfLeaves());

            leaveTypeRequestList.add(leaveTypeRequest);
        }

        return leaveTypeRequestList;
    }

    @Override
    public NotificationRequest toNotificationDto(Notification notification) {
        if(notification == null) {
            return null;
        }

        NotificationRequest notificationRequest = new NotificationRequest();

        notificationRequest.setId(notification.getId());
        notificationRequest.setType(notification.getType());
        notificationRequest.setUserId(notification.getUserId());
        notificationRequest.setRemarks(notification.getRemarks());
        notificationRequest.setAttributeList(notification.getAttributeList());

        return notificationRequest;
    }

}
