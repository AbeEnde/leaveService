package com.orbit.mapper;

import com.orbit.service.dto.models.*;
import com.orbit.service.dto.request.*;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Generated(value = "org.mapstruct.ap.MappingProcessor")
@Component
public class DtoMapperImpl implements DtoMapper {
    @Override
    public Employee toEmployeeEntity(EmployeeRequest employeeRequest) {
        if(employeeRequest == null) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId(employeeRequest.getId());
        employee.setEmployeeName(employeeRequest.getEmployeeName());
        employee.setManagerId(employeeRequest.getManagerId());
        employee.setJoiningDate(employeeRequest.getJoiningDate());
        employee.setUserId(employeeRequest.getUserId());
        employee.setLeaveBalance(employeeRequest.getLeaveBalance());

        return employee;
    }

    @Override
    public Holiday toHolidayEntity(HolidayRequest holidayRequest) {
        if(holidayRequest == null) {
            return null;
        }

        Holiday holiday = new Holiday();

        holiday.setId(holidayRequest.getId());
        holiday.setDate(holidayRequest.getDate());
        holiday.setRegion(holidayRequest.getRegion());
        holiday.setDescription(holidayRequest.getDescription());
        holiday.setCountry(holidayRequest.getCountry());

        return holiday;
    }

    @Override
    public Leave toLeaveEntity(LeaveRequest leaveRequest) {
        if(leaveRequest == null) {
            return null;
        }

        Leave leave = new Leave();

        leave.setId(leaveRequest.getId());
        leave.setEmployeeId(leaveRequest.getEmployeeId());
        leave.setManagerId(leaveRequest.getManagerId());
        leave.setStartDate(leaveRequest.getStartDate());
        leave.setEndDate(leaveRequest.getEndDate());
        leave.setNumberOfLeaves(leaveRequest.getNumberOfLeaves());
        leave.setLeaveStatus(leaveRequest.getLeaveStatus());
        leave.setCreationTime(leaveRequest.getCreationTime());
        leave.setUpdateTime(leaveRequest.getUpdateTime());
        leave.setRemark(leaveRequest.getRemark());
        leave.setLeaveType(leaveRequest.getLeaveType());

        return leave;
    }

    @Override
    public LeaveType toLeaveTypeEntity(LeaveTypeRequest leaveTypeRequest) {
        if(leaveTypeRequest == null) {
            return null;
        }

        LeaveType leaveType = new LeaveType();

        leaveType.setId(leaveTypeRequest.getId());
        leaveType.setLeaveType(leaveTypeRequest.getLeaveType());
        leaveType.setNumOfLeaves(leaveTypeRequest.getNumOfLeaves());

        return leaveType;
    }

    @Override
    public Notification toNotificationEntity(NotificationRequest notificationRequest) {
        if(notificationRequest == null) {
            return null;
        }

        Notification notification = new Notification();

        notification.setId(notificationRequest.getId());
        notification.setType(notificationRequest.getType());
        notification.setUserId(notificationRequest.getUserId());
        notification.setRemarks(notificationRequest.getRemarks());
        notification.setAttributeList(notificationRequest.getAttributeList());

        return notification;
    }

}
