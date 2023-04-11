package com.orbit.service;

import com.orbit.service.dto.request.EmployeeRequest;
import com.orbit.mapper.DtoMapper;
import com.orbit.mapper.EntityMapper;
import com.orbit.service.dto.models.Employee;
import com.orbit.repository.EmployeeRepository;
import com.orbit.service.dto.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EntityMapper entityMapper;

    @Autowired
    private DtoMapper dtoMapper;

    public EmployeeResponse updateLeaveBalance(Long employeeId, EmployeeRequest employeeRequest){
        try {
            Employee employeeToUpdate = employeeRepository.findById(employeeId).get();
            employeeToUpdate.setLeaveBalance(employeeRequest.getLeaveBalance());
            return new EmployeeResponse(HttpStatus.OK, entityMapper.toEmployeeDto(employeeRepository.save(employeeToUpdate)));
        } catch (Exception e) {
            return new EmployeeResponse(HttpStatus.BAD_REQUEST);
        }
    }

    public EmployeeResponse getLeaveBalance(Long employeeId){
        try {
            Employee employee = employeeRepository.findById(employeeId).get();
            return new EmployeeResponse(HttpStatus.OK, employee.getLeaveBalance());
        } catch (Exception e) {
            return new EmployeeResponse(HttpStatus.BAD_REQUEST);
        }
    }

    public EmployeeResponse save(EmployeeRequest employeeRequest){
        Employee result = employeeRepository.save(dtoMapper.toEmployeeEntity(employeeRequest));
        return new EmployeeResponse(HttpStatus.OK, "employee " + result.getId() + " added successfully");
    }

}
