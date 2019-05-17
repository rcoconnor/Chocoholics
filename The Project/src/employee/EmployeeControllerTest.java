package employee;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * this is to test the employeeController.
 * @author ryanbruns
 *
 */

class EmployeeControllerTest {

  @BeforeEach
  void setUp() throws Exception {
    
  }

  @Test
  void testSuccessEmployeeController() {
    Employee myEmp = new Employee(123); 
   
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
    
      EmployeeController newController; 
      newController = new EmployeeController(); 
      newController.addEmployee(myEmp);
    }); 
  }
  
  @Test
  void testSanity() {
    Employee myEmp = new Employee(1234); 
    
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      
      EmployeeController newController; 
      newController = new EmployeeController(); 
      newController.addEmployee(myEmp);
      
    }); 
    
    
    
  }
  
  @Test
  void testBadNumbers() {
    Employee newEmp = new Employee("11812654"); 
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      EmployeeController newController = new EmployeeController(); 
      newController.addEmployee(newEmp);
    }); 
  }
  
  
  

}
