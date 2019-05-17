package services;

import static org.junit.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import serviceRecordTests.ServiceRecord;
/**
 * This class tests the ServiceRecord.
 * @author alecsabatier
 *
 */
class ServiceRecordTest {

  ServiceRecord myRecord;

  @BeforeEach
  void setUp() throws Exception {
    myRecord = new ServiceRecord("01-01-19", "01-02-19", "3:20PM", "rory", "1234", 
        "4321", "1181", "26.54", "no");
  }

  @Test
  void testBadMemberNumbers() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      ServiceRecord badRecord = new ServiceRecord("01-01-19", "01/02/19", "3:20PM", 
          "rory", "-1234", "4321", "1181",
          "26.54", "no");
      badRecord.getMemberNumber();
    });
  }

  @Test
  void testSuccessMemberName() {
    assertEquals("rory", myRecord.memberName);
  }

  @Test
  void testSuccessDateOfService() {
    assertEquals("01-01-19", myRecord.dateOfService);
  }

  @Test
  void testSuccessDateRecorded() {
    assertEquals("01-02-19", myRecord.dateRecorded);
  }

  @Test
  void testSuccessTimeRecorded() {
    assertEquals("3:20PM", myRecord.timeRecorded);
  }

  @Test
  void testSuccessServiceFee() {
    assertEquals("26.54", myRecord.serviceFee);
  }

  @Test
  void testSuccessProviderNumber() {
    assertEquals("4321", myRecord.providerNumber);
  }

  @Test
  void testSanityServiceCode() {
    assertEquals("1181", myRecord.getServiceCode());
  }

}
