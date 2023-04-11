package com.orbit.service.dto.response;


import com.orbit.service.dto.request.EmployeeRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
@Setter
public class EmployeeResponse {

    HttpStatus status;

    String response;

    EmployeeRequest employeeRequest;


    public EmployeeResponse(HttpStatus status, String response, EmployeeRequest employeeRequest) {
        this.status = status;
        this.response = response;
        this.employeeRequest = employeeRequest;
    }

    public EmployeeResponse(HttpStatus status, String response) {
        this.status = status;
        this.response = response;
    }

    public EmployeeResponse(HttpStatus status, EmployeeRequest employeeRequest) {
        this.status = status;
        this.employeeRequest = employeeRequest;
    }

    public EmployeeResponse(HttpStatus status) {
        this.status = status;
    }

}
