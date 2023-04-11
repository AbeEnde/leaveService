package com.orbit.service.dto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "holiday")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @Column(name = "date", nullable = false)
    @Getter
    @Setter
    private LocalDate date;

    @Column(name = "region", nullable = false)
    @Getter
    @Setter
    private String region;

    @Column(name = "description", nullable = true)
    @Getter
    @Setter
    private String description;

    @Column(name = "country", nullable = true)
    @Getter
    @Setter
    private String country;
    public Holiday()
    {

    }
}
