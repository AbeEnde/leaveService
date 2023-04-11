package com.orbit.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveTypeRequest {

    @JsonProperty("id")
    private long id;

    @JsonProperty("leaveType")
    private String leaveType;

    @JsonProperty("numOfLeaves")
    private int numOfLeaves;

}
