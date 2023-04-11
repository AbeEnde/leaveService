package com.orbit.service;

import com.orbit.mapper.EntityMapper;
import com.orbit.service.dto.models.Notification;
import com.orbit.repository.NotificationRepository;
import com.orbit.service.dto.request.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    private EntityMapper entityMapper;

    public NotificationRequest send(String notificationType, String remarks){
       return entityMapper.toNotificationDto(notificationRepository.save(addAttributes(notificationType, remarks)));
    }

    private Notification addAttributes(String notificationType, String remarks) {
           Notification notif = new Notification();
        switch (notificationType.toLowerCase()) {
            case "apply leave":
            case "aapplyleave":
                notif = Notification.builder()
                        .type("Apply Leave")
                        .userId("ab1")
                        .remarks(remarks)
                        .attributeList(new ArrayList<>(Arrays.asList("start date", "end date", "Attr3")))
                        .build();
                break;
            case "reject leave":
            case "rejectleave":
                notif = Notification.builder()
                        .type("Reject Leave")
                        .userId("ab1")
                        .remarks(remarks)
                        .attributeList(new ArrayList<>(Arrays.asList("Attr1", "Attr2")))
                        .build();
                break;
            case "approve leave":
            case "approveleave":
                notif = Notification.builder()
                        .type("Approve Leave")
                        .userId("ab1")
                        .remarks(remarks)
                        .attributeList(new ArrayList<>(Arrays.asList("Attr1", "Attr2")))
                        .build();
                System.out.println("+++"+notif.getType());
                break;
            case "delete leave":
            case "deleteleave":
                notif = Notification.builder()
                        .type("Delete Leave")
                        .userId("ab1")
                        .remarks(remarks)
                        .attributeList(new ArrayList<>(Arrays.asList("Attr1", "Attr2")))
                        .build();
                break;
            default:
                notif = Notification.builder()
                        .type("Type mismatched")
                        .userId("ab1")
                        .remarks("not")
                        .attributeList(new ArrayList<>(Arrays.asList("not", "not")))
                        .build();
        }
        return notif;
    }

}
