package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import alecservicecodes.EmailHandler;
import elleuser.Member;
import elleuser.MemberController;
import reportcodesryan.ReportWriter;

import org.junit.jupiter.api.Assertions;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testing createMemberReport.
 * @author roryoconnor
 *
 */

class RoryTests {


void testsMemberCreateName() {
    MemberController controller = new MemberController();
    String num = controller.addMember("name", "streetAddress", "city", "state", "zip");
    Member member = controller.searchByNum(num);
    Assertions.assertEquals(member.getName(),"name");
    controller.deleteMember(num);
  }

  @Test//Success//
void testsMemberCreateAddress() {
    MemberController controller = new MemberController();
    String num = controller.addMember("name", "streetAddress", "city", "state", "zip");
    Member member = controller.searchByNum(num);
    Assertions.assertEquals(member.getStreetAddress(),"streetAddress");
    controller.deleteMember(num);
  }

  @Test//Success//
void testsMemberCreateCity() {
    MemberController controller = new MemberController();
    String num = controller.addMember("name", "streetAddress", "city", "state", "zip");
    Member member = controller.searchByNum(num);
    Assertions.assertEquals(member.getCity(),"city");
    controller.deleteMember(num);
  }

  @Test//Success//
void testsMemberCreateState() {
    MemberController controller = new MemberController();
    String num = controller.addMember("name", "streetAddress", "city", "state", "zip");
    Member member = controller.searchByNum(num);
    Assertions.assertEquals(member.getState(),"state");
    controller.deleteMember(num);
  }
  
  @Test//Success//
void testsMemberCreateZip() {
    MemberController controller = new MemberController();
    String num = controller.addMember("name", "streetAddress", "city", "state", "zip");
    Member member = controller.searchByNum(num);
    Assertions.assertEquals(member.getZip(),"zip");
    controller.deleteMember(num);
  }
  /*
   * This tests for failure
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
