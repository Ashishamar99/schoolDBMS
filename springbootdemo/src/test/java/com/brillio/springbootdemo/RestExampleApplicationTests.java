package com.brillio.springbootdemo;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestExampleApplicationTests {

	@Autowired
	MyRestController controller;

	@Autowired
	CrudController crudController;

	@Test
	@Order(1)
	public void testDTOAvailableOrNot(){
		try{
			StudentDTO studentDTO = new StudentDTO();
		} catch (Exception e){
			Assert.fail();
		}
	}

	//2nd Test Case.
	@Test
	@Order(2)
	public void testDTOAvailableOrNot1(){
		try{

			StudentDTO studentDTO = new StudentDTO();
			studentDTO.getAddress();
			studentDTO.getDob();

		} catch (Exception e){
			Assert.fail();
		}
	}

	@Test
	@Order(3)
	public void testFetchAllStudents(){
		try{

			List<StudentDTO> list = controller.getStudents();
			if(list == null) throw new Exception();

		} catch (Exception e){
			Assert.fail();
		}
	}

	@Test
	@Order(4)
	public void testFetchAllStudentsUsingAssert(){
		try{

			List<StudentDTO> list = controller.getStudents();
			assertNotNull(list);

		} catch (Exception e){
			Assert.fail();
		}
	}

	@Test
	@Order(5)
	public void testFetchUnknownStudent() {
		try {
			Optional<StudentDTO> list= controller.getAnyStudent("5000");
			assertEquals(list, Optional.empty());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Order(6)
	public void testCrudControllerInsertion(){
		try {
			StudentDTO student = new StudentDTO();
			student.setSid("150");
			student.setAddress("abc, def");
			student.setFname("Gamma");
			student.setLname("Delta");
			student.setDob("1991-01-01");
			String result = crudController.insertStudent(student);
			assertEquals(result, "Data is Inserted");
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(7)
	public void testCrudControllerUpdate(){
		try {
			StudentDTO student = new StudentDTO();
			student.setSid("150");
			student.setAddress("abc, def");
			student.setFname("Zeta");
			student.setLname("Delta");
			student.setDob("1991-01-01");
			String result = crudController.updateStudent(student);
			assertEquals(result, "Data is Updated");
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(8)
	public void testCrudControllerDelete(){
		try {
			String result = crudController.deleteStudent("150");
			assertEquals(result, "Data is Deleted");
		} catch (Exception e){
			fail();
		}
	}

	@Test
	@Order(9)
	public void testFailureCrudControllerDelete(){
		try {
			String result = crudController.deleteStudent("1650");
			assertNotEquals(result, "Data is Deleted");
			//Since ID 1650 doesn't exist the message will be "No class com.brillio.springbootdemo.StudentDTO entity with id 1650 exists!"
		} catch (Exception e){
			fail();
		}
	}

}