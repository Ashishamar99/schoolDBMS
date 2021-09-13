import com.brillio.springbootdemo.CrudController;
import com.brillio.springbootdemo.StudentDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentEnroll {

    StudentDTO studentDTO;
    CrudController controller;
    String result;
//
//    @Given("A student enrolls and fills the application")
//    public void aStudentEnrolls() {
//        controller = new CrudController();
//        studentDTO = new StudentDTO();
//
//    }
//
//    @When("Data is collected using the application")
//    public void theDataIsCollected() {
//        studentDTO.setSid("152");
//        studentDTO.setFname("ABCD");
//        studentDTO.setLname("GHIJ");
//        studentDTO.setAddress("asfsdfdsg");
//        studentDTO.setDob("1991-06-25");
//
//        result = controller.insertStudent(studentDTO);
//
//    }
//
//    @Then("Data is added in the database")
//    public void dataIsAddedInTheDatabase() {
//        assertEquals(result, "Data is Inserted");
//    }

}
