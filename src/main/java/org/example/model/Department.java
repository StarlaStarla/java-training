package org.example.model;

import lombok.*;

@Data
public class Department {

    @NonNull
    private Integer id;

    private String dname;

    private String location;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getDname() {
//        return dname;
//    }
//
//    public void setDname(String dname) {
//        this.dname = dname == null ? null : dname.trim();
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location == null ? null : location.trim();
//    }
//
//    @Override
//    public String toString() {
//        return "Department: id:" + this.getId() + ", name:" + this.getDname() + ", location:" + this.getLocation();
//    }
}