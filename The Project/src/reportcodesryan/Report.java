package reportcodesryan;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Report {
  int reportID; 
  String reportDate; 
  boolean reportOrigin;

  /*
   * String indices meanings: 
   *   0: date of service (MM-DD-YYYY)
   *   1: date/time recorded (MM-DD-YYYY HH-MM-SS)
   *   2: member name
   *   3: member number
   *   4: provider number
   *   5: service code
   *   6: service fee
   *   7: service name
   *   8: provider name
   */
  ArrayList<String[]> listOfServices;
  String home;
  String path;
  File file;

  /**
   * Basic constructor.
   */
  
  public Report() {
    //Nothing of note
  }

  /**
   * This method collects the current date and saves it as a string.
   */
  
  public void setDate() {
    String pattern = "MM_dd_yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    reportDate = simpleDateFormat.format(new Date());
    return;
  }
  
  /**
   * This method adds a service to the listOfServices array.
   * @param service - The service to be added.
   * @param member - Sorts member reports and provider reports differently.
   */
  
  @SuppressWarnings("deprecation")
  public void addService(String[] service, Boolean member) {
    if (listOfServices.size() == 0) {
      listOfServices.add(service);
      return;
    }
    int pos;
    int serviceYear;
    int serviceMonth;
    int serviceDay;
    int serviceHour;
    int serviceMin;
    int serviceSec;
    Date serviceDate;

    if (member == false) {
      serviceYear = Integer.parseInt(service[1].substring(6,10));
      serviceMonth = Integer.parseInt(service[1].substring(0,2));
      serviceDay = Integer.parseInt(service[1].substring(3,5));
      serviceHour = Integer.parseInt(service[1].substring(11,13));
      serviceMin = Integer.parseInt(service[1].substring(14,16));
      serviceSec = Integer.parseInt(service[1].substring(17));
    } else {
      serviceYear = Integer.parseInt(service[0].substring(6));
      serviceMonth = Integer.parseInt(service[0].substring(0,2));
      serviceDay = Integer.parseInt(service[0].substring(3,5));
      serviceHour = 0;
      serviceMin = 0;
      serviceSec = 0;
    }

    serviceDate = new Date(serviceYear - 1900,serviceMonth - 1,
      serviceDay, serviceHour, serviceMin, serviceSec);
    pos = findSpot(serviceDate, member);
    listOfServices.add(pos,service);
    return;
  }

  /**
   * This method finds the spot in ListOfServices to put the added service.
   * @param serviceDate - Finds the service's spot based on date.
   * @param member - Sorts based on service date if member report and date received by computer if
       provider report.
   * @return
   */
  
  @SuppressWarnings("deprecation")
  private int findSpot(Date serviceDate, boolean member) {
    int day;
    int month;
    int year;
    int hour;
    int min;
    int sec;
    Date date;
    int numberOfServices = listOfServices.size();

    int i = 0;

    do {
      if (i == numberOfServices) {
        i++;
        break;
      }
      if (member == false) {
        day = Integer.parseInt(listOfServices.get(i)[1].substring(3,5));
        month = Integer.parseInt(listOfServices.get(i)[1].substring(0,2));
        year = Integer.parseInt(listOfServices.get(i)[1].substring(6,10));
        hour = Integer.parseInt(listOfServices.get(i)[1].substring(11,13));
        min = Integer.parseInt(listOfServices.get(i)[1].substring(14,16));
        sec = Integer.parseInt(listOfServices.get(i)[1].substring(17));
      } else {
        day = Integer.parseInt(listOfServices.get(i)[0].substring(3,5));
        month = Integer.parseInt(listOfServices.get(i)[0].substring(0,2));
        year = Integer.parseInt(listOfServices.get(i)[0].substring(6,10));
        hour = 0;
        min = 0;
        sec = 0;
      }

      date = new Date(year - 1900, month - 1, day, hour, min, sec);

      i++;
    } while (serviceDate.after(date) == true);
    return i - 1;
  }

}
