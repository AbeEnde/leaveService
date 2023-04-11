package com.orbit.service.dto.response;

import com.orbit.service.dto.request.LeaveRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class LeaveResponse {

    HttpStatus status;

    String response;

    LeaveRequest leaveRequest;

    List<LeaveRequest> leaveRequestList = new ArrayList<>();


    public LeaveResponse(HttpStatus status, String response, LeaveRequest leaveRequest) {
        this.status = status;
        this.response = response;
        this.leaveRequest = leaveRequest;
    }

    public LeaveResponse(HttpStatus status, String response) {
        this.status = status;
        this.response = response;
    }

    public LeaveResponse(HttpStatus status, LeaveRequest leaveRequest) {
        this.status = status;
        this.leaveRequest = leaveRequest;
    }

    public LeaveResponse(HttpStatus status, List<LeaveRequest> leaveRequestList) {
        this.status = status;
        this.leaveRequestList = leaveRequestList;
    }

    public LeaveResponse(HttpStatus status) {
        this.status = status;
    }

}
