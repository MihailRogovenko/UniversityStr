package com.tpp.UniversityStr.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "curators")
public class Curators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer curatorId;

    @NotBlank
    private String name;

    @Min(27)
    private Integer age;

    @NotBlank
    private String department;

    @OneToOne(mappedBy = "curator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Groups group;

    // Getters and Setters
    public Integer getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(Integer curatorId) {
        this.curatorId = curatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }
}
