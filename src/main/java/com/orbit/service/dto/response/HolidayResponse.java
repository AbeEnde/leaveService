package com.orbit.service.dto.response;

import com.orbit.service.dto.request.HolidayRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
@Setter
public class HolidayResponse {

    HttpStatus status;

    String response;

    HolidayRequest holidayRequest;


    public HolidayResponse(HttpStatus status, String response, HolidayRequest holidayRequest) {
        this.status = status;
        this.response = response;
        this.holidayRequest = holidayRequest;
    }

    public HolidayResponse(HttpStatus status, String response) {
        this.status = status;
        this.response = response;
    }

    public HolidayResponse(HttpStatus status, HolidayRequest holidayRequest) {
        this.status = status;
        this.holidayRequest = holidayRequest;
    }

    public HolidayResponse(HttpStatus status) {
        this.status = status;
    }

}
