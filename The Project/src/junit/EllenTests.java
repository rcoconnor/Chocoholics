package junit;

import alecservicecodes.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**Tests Service Class.
 * 
 * @author Ellen DiSilverio 11770725
 *  */
class EllenTests {
  @Test // success //
    void testCorrectCode() {
    Service service = new Service("111111","1","name");
    Assertions.assertEquals(service.getCode(),"111111");
  }

  @Test // success //
    void testCorrectName() {
    Service service = new Service("111111","1","name");
    Assertions.assertEquals(service.getName(),"name");
  }

  @Test//failure//
  public void testConstructWithBadInfo() {
  Assertions.assertThrows(IllegalArgumentException.class,() ->{Service servie = new Service ("j","7","g");});
  }
}
