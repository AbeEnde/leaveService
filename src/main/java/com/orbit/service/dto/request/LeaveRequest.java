package com.orbit.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LeaveRequest {

    @JsonProperty("id")
    private long id;

    @JsonProperty("employeeId")
    private long employeeId;

    @JsonProperty("managerId")
    private long managerId;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;

    @JsonProperty("numberOfLeaves")
    private double numberOfLeaves;

    @JsonProperty("leaveStatus")
    private String leaveStatus;

    @JsonProperty("creationTime")
    private LocalDate creationTime;

    @JsonProperty("updateTime")
    private LocalDate updateTime;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("leaveType")
    private String leaveType;

}
