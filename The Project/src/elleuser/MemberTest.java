package elleuser;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberTest {

  Member mem;
    
  @BeforeEach
  void setUp() throws Exception {
    mem = new Member("John Egbert", "142 Sburbia Lane", 
            "LOFAF", "Earth C", "612413", "123456789", "1");
  }

  @Test
  void successName() {
    assertEquals("John Egbert", mem.getName());
  }
  
  @Test
  void successNum() {
    assertEquals("123456789", mem.getNumber());
  }
  
  @Test
  void successAddress() {
    assertEquals("142 Sburbia Lane", mem.getStreetAddress());
  }
  
  @Test
  void failureNum() {
    
  }
}
