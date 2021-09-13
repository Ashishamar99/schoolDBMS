package com.brillio.springbootdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksDAO extends JpaRepository<MarksDTO, String> {

    @Query(value = "select s.fname,avg((m1+m2+m3)/3) as average,count(testno) as Tests from marks join sdetails s on s.sid = mark.sid group by mark.sid;", nativeQuery = true)
    public List<String> getAvgMarks();

}
