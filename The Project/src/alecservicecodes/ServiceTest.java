package alecservicecodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServiceTest {
  
  Service theService; 

  @BeforeEach
  void setUp() throws Exception {
    theService = new Service("118134", "26", "name"); 
  }

  
  @Test 
  void testSuccessConstructor() {
    assertEquals(theService.getCode(), 1181); 
    assertEquals(theService.getFee(), "26"); 
    assertEquals(theService.getName(), "name"); 
  }
  
  @Test
  void testSuccessGetCode() {
    assertEquals(theService.getCode(), 1181); 
  }
  
  @Test 
  void testSuccessGetName() {
    assertEquals(theService.getName(), "name"); 
  }
  
  @Test 
  void testSuccessGetFee() {
    assertEquals(theService.getFee(), "26"); 
  }
  
  @Test
  void testSucessSetCode() {
    theService.setCode("265434");
    assertEquals(theService.getCode(), "265434"); 
  }
  
  @Test
  void testSuccessSetFee() {
    theService.setFee("52");
    assertEquals(theService.getFee(), 52); 
  }
  
  @Test
  void testSuccessSetName() {
    theService.setName("rory");
    assertEquals(theService.getName(), "rory"); 
  }
  
  @Test
  void testSuccessPrint() {
    assertEquals("Name: name. Number: 1181. Fee: 26.", theService.print()); 
  }
  
  @Test 
  void testFailureSetFee() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      theService.setFee("-1"); 
    }); 
  }
  

}
