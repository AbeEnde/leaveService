package com.orbit.service.dto.response;

import com.orbit.service.dto.request.NotificationRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
@Setter
public class NotificationResponse {

    HttpStatus status;

    String response;

    NotificationRequest notificationRequest;

    public NotificationResponse(HttpStatus status, String response, NotificationRequest notificationRequest) {
        this.status = status;
        this.response = response;
        this.notificationRequest = notificationRequest;
    }

    public NotificationResponse(HttpStatus status, String response) {
        this.status = status;
        this.response = response;
    }

    public NotificationResponse(HttpStatus status, NotificationRequest notificationRequest) {
        this.status = status;
        this.notificationRequest = notificationRequest;
    }

    public NotificationResponse(HttpStatus status) {
        this.status = status;
    }

}
