package junit;

import elleuser.Provider;
import elleuser.ProviderController;
import reportcodesryan.ReportWriter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class EmersonTests {


  /**
  * These tests checks that the add provider method works.
  * @author Emerson
  * 
  */
  @Test //Success//
void testsProviderCreateName() {
    ProviderController controller = new ProviderController();
    String num = controller.addProvider("name", "streetAddress", "city", "state", "zip");
    Provider provider = controller.searchByNum(num);
    assertEquals(provider.getName(),"name");
    controller.deleteProvider(num);
  }

  @Test//Success//
void testsProviderCreateAddress() {
    ProviderController controller = new ProviderController();
    String num = controller.addProvider("name", "streetAddress", "city", "state", "zip");
    Provider provider = controller.searchByNum(num);
    assertEquals(provider.getStreetAddress(),"streetAddress");
    controller.deleteProvider(num);
  }

  @Test//Success//
void testsProviderCreateCity() {
    ProviderController controller = new ProviderController();
    String num = controller.addProvider("name", "streetAddress", "city", "state", "zip");
    Provider provider = controller.searchByNum(num);
    assertEquals(provider.getCity(),"city");
    controller.deleteProvider(num);
  }

  @Test//Success//
void testsProviderCreateState() {
    ProviderController controller = new ProviderController();
    String num = controller.addProvider("name", "streetAddress", "city", "state", "zip");
    Provider provider = controller.searchByNum(num);
    assertEquals(provider.getState(),"state");
    controller.deleteProvider(num);
  }
  
  @Test//Success//
void testsProviderCreateZip() {
    ProviderController controller = new ProviderController();
    String num = controller.addProvider("name", "streetAddress", "city", "state", "zip");
    Provider provider = controller.searchByNum(num);
    assertEquals(provider.getZip(),"zip");
    controller.deleteProvider(num);
  }
  
  
  /**
   * This tests for failure.
   * 
   */
  @Test//Failure
void testsFailure() {
    ReportWriter control = new ReportWriter();
    Assertions.assertThrows(NullPointerException.class,  () -> {
      control.writeMemberReport("122373485654321");
    });
  }
  
  
  
}
