package com.example.demo.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@ToString
public class Department extends BaseEntity {

    @Column(
            nullable = false,
            unique = true
    )
    private String name;

    @OneToMany(mappedBy = "id")
    private List<Course> course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id",referencedColumnName = "id")
    private Lecturer lecturer;
}
