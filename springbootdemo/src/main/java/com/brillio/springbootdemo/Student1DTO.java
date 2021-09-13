package com.brillio.springbootdemo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sdetails")
public class Student1DTO {
    @Id
    @GeneratedValue
    private String sid;

    @Column
    String fname;

    @Column
    String lname;

    @Column
    String dob;

    @Column
    String address;

    //*************One To Many*************
    @OneToMany
    @JoinColumn(name = "sid")
    List<MarksDTO> marksList;

    public List<MarksDTO> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<MarksDTO> marksList) {
        this.marksList = marksList;
    }


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
