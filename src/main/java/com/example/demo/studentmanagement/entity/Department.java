package com.example.demo.studentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Department extends BaseEntity {

    @Column(
            nullable = false,
            unique = true
    )
    private String name;
}
