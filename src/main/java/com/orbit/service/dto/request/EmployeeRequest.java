package com.orbit.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeRequest {

    @JsonProperty("id")
    private long id;

    @JsonProperty("employeeName")
    private String employeeName;

    @JsonProperty("managerId")
    private long managerId;

    @JsonProperty("joiningDate")
    private Date joiningDate;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("leaveBalance")
    private String leaveBalance;

}
