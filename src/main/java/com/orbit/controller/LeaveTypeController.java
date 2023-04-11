package com.orbit.controller;

import com.orbit.constants.APIPaths;
import com.orbit.service.dto.request.LeaveTypeRequest;
import com.orbit.service.dto.response.LeaveTypeResponse;
import com.orbit.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(APIPaths.LEAVE_TYPE_MAPPING)
public class LeaveTypeController {
    @Autowired
    private LeaveTypeService leaveTypeService;
    @PostMapping()
    public LeaveTypeRequest createLeaveType(@Validated @RequestBody LeaveTypeRequest leaveTypeRequest)
    {
        return leaveTypeService.save(leaveTypeRequest);
    }
    @GetMapping(APIPaths.GET_LEAVE_TYPE)
    public LeaveTypeResponse getLeaveTypeById(@PathVariable(value = "id") Long leaveTypeId)
    {
        return leaveTypeService.findLeaveTypeById(leaveTypeId);
    }

    @GetMapping
    public List<LeaveTypeRequest> getAllLeaveType()
    {
        return leaveTypeService.findAllLeaveType();
    }
    @DeleteMapping(APIPaths.DELETE_LEAVE_TYPE)
    public LeaveTypeResponse deleteLeaveType(@PathVariable(value = "id") Long leaveTypeId)
    {
      return leaveTypeService.deleteLeaveType(leaveTypeId);
    }
    @PutMapping(APIPaths.UPDATE_LEAVE_TYPE)
    public LeaveTypeResponse updateLeaveType(@PathVariable(value = "id") Long leaveTypeId, @Validated @RequestBody LeaveTypeRequest leaveTypeRequest)
    {
        return leaveTypeService.update(leaveTypeId, leaveTypeRequest);
    }
}
