package emersonmenus;

//import elleuser.*;

//import reportcodesryan.*;

import elleuser.MemberController;
import elleuser.ProviderController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import reportcodesryan.ReportWriter;

//import java.util.*;

import services.ServiceController;

public class AccountingProcedure implements Runnable {

  /**
   * This is a seperately threaded timer that checks every 20 seconds if its friday at 11:59 and
   * if it is, it queues up all the reports needed, then sleeps for 2 hours to ensure no duplicate
   * reports.
   * @author Emerson
   *
   */

  public AccountingProcedure() {
    // System.out.println("hey heres the constructor");
  }
  
  /**
   * This is the method that is called to instantiate the timer.
   * @author Emerson
   */
  public void run() {
    // This is the timer. It asks if its friday at 11:59(not yet actually)
    // below are some documentation
    // https://www.tutorialspoint.com/java/util/calendar_getinstance.htm
    // https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
    // https://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.html

    SimpleDateFormat sdf = new SimpleDateFormat("uHHmm");
    // System.out.println("spaghetti");

    while (true) {
      Calendar cal = Calendar.getInstance();
      String time = sdf.format(cal.getTime());

      if (time.contentEquals("51249")) {
        // 52359 is the sequence we're looking for(friday23)
        // This is when the time is correct
        System.out.println(time);

        // get list of provider numbers

        ServiceController serviceController = new ServiceController();
        ProviderController providerController = new ProviderController();
        MemberController memberController = new MemberController();
        ReportWriter writer = new ReportWriter();

        ArrayList<String> providers = new ArrayList<String>();
        providers = providerController.getAllProviderNumbers();
        for (int i = 0; i < providers.size(); i++) {
          // check if provider has service records associated
          boolean tempVar = serviceController.exists(providers.get(i));
          if (tempVar == false) {
            System.out.println("no records");
            continue;
          }
          // so otherwise the provider has records, so we'll tell
          // report writer to write a report for that member
          System.out.println("records");
          try {
            writer.writeProviderReport(providers.get(i));
          } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IO exception", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
          continue;
        }

        ArrayList<String> members = new ArrayList<String>();
        members = memberController.getAllMemberNumbers();
        for (int i = 0; i < members.size(); i++) {
          // check if member has service records associated
          boolean tempVar = serviceController.exists(members.get(i));
          if (tempVar == false) {
            System.out.println("no records");
            continue;
          }
          // so otherwise the member has records, so we'll tell
          // report writer to write a report for that member
          System.out.println("records");
          try {
            writer.writeMemberReport(members.get(i));
          } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IO exception", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
          continue;

        }

        // run summ. report;
        // run eft report;
        try {
          writer.writeSummaryReport();
        } catch (IOException e1) {
          JOptionPane.showMessageDialog(null, "IO exception", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        try {
          writer.writeEftReport();
        } catch (IOException e1) {
          JOptionPane.showMessageDialog(null, "IO exception", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        try {
          TimeUnit.MINUTES.sleep(120);
        } catch (InterruptedException e) {
          System.out.print("error in accounting procedure timer 1");
          e.printStackTrace();
        }

      }

      try {
        TimeUnit.SECONDS.sleep(20);
      } catch (InterruptedException e) {
        System.out.print("error in accounting procedure timer 2");
        e.printStackTrace();
      }
    }
  }
}
