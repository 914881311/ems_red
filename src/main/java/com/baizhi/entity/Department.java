package com.baizhi.entity;

import org.springframework.stereotype.Component;

@Component
public class Department {
    private Integer depart_id;
    private String depart_name;
    private String depart_number;

    @Override
    public String toString() {
        return "Department{" +
                "depart_id=" + depart_id +
                ", depart_name='" + depart_name + '\'' +
                ", depart_number='" + depart_number + '\'' +
                '}';
    }

    public Department(Integer depart_id, String depart_name, String depart_number) {
        this.depart_id = depart_id;
        this.depart_name = depart_name;
        this.depart_number = depart_number;
    }

    public Department() {
        super();
    }

    public Integer getDepart_id() {
        return depart_id;
    }

    public void setDepart_id(Integer depart_id) {
        this.depart_id = depart_id;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public String getDepart_number() {
        return depart_number;
    }

    public void setDepart_number(String depart_number) {
        this.depart_number = depart_number;
    }
}
