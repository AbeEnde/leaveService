package com.orbit.controller;

import com.orbit.constants.APIPaths;
import com.orbit.service.dto.models.Notification;
import com.orbit.service.NotificationService;
import com.orbit.service.dto.request.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIPaths.NOTIFICATION_MAPPING)
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @PostMapping(APIPaths.NOTIFY)
    public NotificationRequest notify(@RequestParam("employeeId") Long employeeId,
                                      @RequestParam("notification_type") String notificationType,
                                      @RequestParam("remarks") String remarks) {
        return notificationService.send(notificationType, remarks);
    }

}
