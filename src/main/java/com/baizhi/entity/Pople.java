package com.baizhi.entity;

import org.springframework.stereotype.Component;

@Component
public class Pople {
    private Integer id;
    private String cover;
    private String name;
    private double salary;
    private Integer age;
    private Integer department_id;
    private Department department;

    @Override
    public String toString() {
        return "Pople{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", department_id=" + department_id +
                ", department=" + department +
                '}';
    }

    public Pople(Integer id, String cover, String name, double salary, Integer age, Integer department_id, Department department) {
        this.id = id;
        this.cover = cover;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.department_id = department_id;
        this.department = department;
    }

    public Pople() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
