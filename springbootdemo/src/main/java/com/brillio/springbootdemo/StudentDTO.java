package com.brillio.springbootdemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.util.List;

@Entity // Will automatically connect this POJO to the table.
@Table(name = "sdetails")
public class StudentDTO {
    @Id //Primary key is defined with an annotation @Id
    //@GeneratedValue //Specifies if the value is automatically incremented by 1.
    private String sid;

    @Column
    String fname;

    @Column
    String lname;

    @Column
    String dob;

    @Column
    String address;

    /*
    This means the field Studentdob is same as dob in the SQL Table.
    @Column(name = "dob")
    String Studentdob;
    */



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
