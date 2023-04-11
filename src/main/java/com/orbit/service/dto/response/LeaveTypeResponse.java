package com.orbit.service.dto.response;

import com.orbit.service.dto.request.LeaveTypeRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class LeaveTypeResponse {

    HttpStatus status;

    String response;

    LeaveTypeRequest leaveTypeRequest;

    List<LeaveTypeRequest> leaveTypeRequests = new ArrayList<>();

    public LeaveTypeResponse(HttpStatus status, String response, LeaveTypeRequest leaveTypeRequest) {
        this.status = status;
        this.response = response;
        this.leaveTypeRequest = leaveTypeRequest;
    }

    public LeaveTypeResponse(HttpStatus status, String response) {
        this.status = status;
        this.response = response;
    }

    public LeaveTypeResponse(HttpStatus status, LeaveTypeRequest leaveTypeRequest) {
        this.status = status;
        this.leaveTypeRequest = leaveTypeRequest;
    }

    public LeaveTypeResponse(HttpStatus status, List<LeaveTypeRequest> leaveTypeRequests) {
        this.status = status;
        this.leaveTypeRequests = leaveTypeRequests;
    }

    public LeaveTypeResponse(HttpStatus status) {
        this.status = status;
    }

}
