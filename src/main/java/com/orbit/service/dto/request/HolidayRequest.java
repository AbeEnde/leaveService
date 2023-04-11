package com.orbit.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HolidayRequest {

    @JsonProperty("id")
    private long id;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("region")
    private String region;

    @JsonProperty("description")
    private String description;

    @JsonProperty("country")
    private String country;

}
