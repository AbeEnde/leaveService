package com.orbit.mapper;

import com.orbit.service.dto.models.*;
import com.orbit.service.dto.request.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoMapper {

    Employee toEmployeeEntity(EmployeeRequest employeeRequest);

    Holiday toHolidayEntity(HolidayRequest holidayRequest);

    Leave toLeaveEntity(LeaveRequest leaveRequest);

    LeaveType toLeaveTypeEntity(LeaveTypeRequest leaveTypeRequest);

    Notification toNotificationEntity(NotificationRequest notificationRequest);

}