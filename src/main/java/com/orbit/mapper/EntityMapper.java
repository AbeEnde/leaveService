package com.orbit.mapper;

import com.orbit.service.dto.models.*;
import com.orbit.service.dto.request.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    EmployeeRequest toEmployeeDto(Employee employee);

    HolidayRequest toHolidayDto(Holiday holiday);

    LeaveRequest toLeaveDto(Leave leave);

    LeaveTypeRequest toLeaveTypeDto(LeaveType leaveType);

    NotificationRequest toNotificationDto(Notification notification);

    List<HolidayRequest> toHolidayDtoList(List<Holiday> holidayList);

    List<LeaveRequest> toLeaveDtoList(List<Leave> leaveList);

    List<LeaveTypeRequest> toLeaveTypeDtoList(List<LeaveType> leaveTypeList);

}
