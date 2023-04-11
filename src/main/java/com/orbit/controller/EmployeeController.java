package com.orbit.controller;

import com.orbit.constants.APIPaths;
import com.orbit.service.dto.request.EmployeeRequest;
import com.orbit.service.dto.response.EmployeeResponse;
import com.orbit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(APIPaths.EMPLOYEE_MAPPING)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PatchMapping(APIPaths.UPDATE_LEAVE_BALANCE)
    public EmployeeResponse updateLeaveBalance(@PathVariable(value = "id") Long employeeId, @Validated @RequestBody EmployeeRequest employeeRequest) {
           return employeeService.updateLeaveBalance(employeeId, employeeRequest);
    }

    @GetMapping(APIPaths.GET_LEAVE_BALANCE)
    public EmployeeResponse getLeaveBalance(@PathVariable(value = "id") Long employeeId) {
           return employeeService.getLeaveBalance(employeeId);
    }

    @PostMapping(APIPaths.ADD_EMPLOYEE)
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest employeeRequest){
           return employeeService.save(employeeRequest);
    }

}
