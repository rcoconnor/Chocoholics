package employee;

import static org.junit.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * this class tests the different use cases of employee.
 * @author ryanbruns
 *
 */
class EmployeeTest {

  Employee myEmployee;

  @BeforeEach
  void setUp() throws Exception {
    myEmployee = new Employee(1234);
  }

  @Test // failure //
  void testNegativeNumbersConstructor() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Employee badEmployee = new Employee(-1234);
      badEmployee.getId();
    });

  }

  @Test // success //
  void testSuccessGetId() {

    String id = myEmployee.getId();
    assertEquals(id, "1234");

  }

  @Test // Sanity //
  void testSanity() {

    myEmployee.setId("2");
    assertEquals(myEmployee.getId(), "2");

  }

}
