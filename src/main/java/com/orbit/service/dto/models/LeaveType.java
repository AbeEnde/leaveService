package com.orbit.service.dto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "leave_type")
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name = "leave_type", nullable = false)
    @Getter
    @Setter
    private String leaveType;
    @Column(name = "num_of_leavs", nullable = false)
    @Getter
    @Setter
    private int numOfLeaves;
}
