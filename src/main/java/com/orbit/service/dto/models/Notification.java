package com.orbit.service.dto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "notification")
@Builder
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Column(name = "type")
    @Getter
    @Setter
    private String type;

    @Column(name = "userId")
    @Getter
    @Setter
    private String userId;

    @Column(name = "remarks")
    @Getter
    @Setter
    private String remarks;

    @Column(name = "attribute_list")
    @Getter
    @Setter
    private List<String> attributeList;

    public Notification() {}



}
