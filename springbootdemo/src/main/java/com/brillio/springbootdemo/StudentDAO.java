package com.brillio.springbootdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository // equivalent to @Component @Bean. Will create an object and store it in the container.
public interface StudentDAO extends JpaRepository<StudentDTO, String> {

    //Here, JpaRepository<StudentDTO, String> "String" specifies the datatype of the primary key.

    public Optional<StudentDTO> findByfname(String fname);
    //The function name should be same as defined in the student dto and database. We can use camel case or the normal case.
    //ie. Function name can be findByfname() or findByFname().

    public Optional<StudentDTO> findByFnameAndLname(String fname, String lname);
    //Here we are using 2 column names fname and lname for the record.
    //But here we have to use only PascalCase naming convention (Capitalize each word's First Letter) including cases like "And"
    //We can use Operators like "And" or "Or" in the function name and that condition will be applied.

    public List<StudentDTO> findAllByFnameAndLname(String fname, String lname);
    //If 2 records have same name ie. fname and lname then return that list.
    //Using the "All" Keyword in the function name.
}
