package com.orbit.controller;

import com.orbit.constants.APIPaths;
import com.orbit.service.dto.models.Leave;
import com.orbit.constants.LeaveStatus;
import com.orbit.service.dto.request.LeaveRequest;
import com.orbit.service.dto.response.LeaveResponse;
import com.orbit.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(APIPaths.LEAVE_MAPPING)
public class LeaveController {

    @Autowired
    LeaveService leaveService;
    @PostMapping()
    public LeaveRequest createLeave(@RequestBody LeaveRequest leaveRequest)
    {
        return leaveService.save(leaveRequest);
    }

    @GetMapping(APIPaths.GET_LEAVE)
    public LeaveResponse getLeaveById(@PathVariable(value = "id") Long leaveId)
    {
      return leaveService.findLeaveById(leaveId);
    }

    @GetMapping(APIPaths.ALL_LEAVE)
    public List<LeaveRequest> getAllLeave()
    {
        return leaveService.findAllLeave();
    }

    @GetMapping(APIPaths.ALL_LEAVE_BY_STATUS)
    public List<LeaveRequest> getAllLeaveByStatus(@RequestParam("employeeId") Long employeeId, @RequestParam("leaveStatus") String leaveStatus)
    {
        return leaveService.findAllLeaveByStatus(employeeId, leaveStatus);
    }
    @GetMapping(APIPaths.ALL_LEAVE_BY_MANAGER_ID)
    public List<LeaveRequest> getAllLeaveByManagerId(@RequestParam("managerId") Long managerId)
    {
        return leaveService.findAllLeaveByManagerId(managerId);
    }

    @GetMapping(APIPaths.ALL_LEAVE_BY_STATUS_MANAGER)
    public List<LeaveRequest> getAllLeaveByStatusForManager(@RequestParam("managerId") Long managerId, @RequestParam("leaveStatus") LeaveStatus leaveStatus)
    {
        return leaveService.findAllLeaveByStatusForManager(managerId, leaveStatus);
    }

    @GetMapping(APIPaths.LEAVE_COUNT_BY_STATUS)
    public Long getLeaveCountByStatusForManager(@RequestParam("managerId") Long managerId, @RequestParam("leaveStatus") LeaveStatus leaveStatus)
    {
        return leaveService.findLeaveCountByStatusForManager(managerId, leaveStatus);
    }
    @GetMapping(APIPaths.LEAVE_BY_EMPLOYEE_ID)
    public List<LeaveRequest> getAllLeaveByEmployeeId(@RequestParam("employeeId") Long employeeId)
    {
        return leaveService.findAllLeaveByEmployeeId(employeeId);
    }
    @PatchMapping(APIPaths.UPDATE_LEAVE)
    public LeaveResponse updateLeave(@RequestBody List<LeaveRequest> leaveRequestList)
    {
       return leaveService.update(leaveRequestList);
    }
    @DeleteMapping(APIPaths.DELETE_LEAVE)
    public LeaveResponse deleteLeave(@PathVariable(value = "id") Long leaveId)
    {
       return leaveService.deleteLeave(leaveId);
    }

}
