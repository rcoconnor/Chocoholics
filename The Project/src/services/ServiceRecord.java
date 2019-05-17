package services;

/**
 * The ServiceRecord class, provides an interface for ServiceController to
 * interact with the ServiceRecords stored on disk.
 * 
 * @author roryoconnor
 *
 */
public class ServiceRecord {

  String dateOfService;
  String dateRecorded;
  String timeRecorded;
  String memberName;
  String serviceFee;
  String commentary;

  String memberNumber;
  String providerNumber;
  String serviceCode;

  /**
   * This constructor creates a new ServiceRecord Object; all of the arguments are
   * strings.
   * 
   * @param dateProvided the date the service was provided
   * @param dateRec      the current date
   * @param timeRec      the current time
   * @param memName      the name of the member
   * @param memNum       the memberNumber
   * @param provNum      the provider number
   * @param servCode     the service code
   * @param servFee      the service fee
   * @param com          optional comments
   * @throws IllegalArgumentException thrown if memNum or provNum are less than or
   *                                  equal to 0
   */
  public ServiceRecord(String dateProvided, String dateRec, String timeRec, String memName, 
      String memNum, String provNum, String servCode, String servFee, String com) 
          throws IllegalArgumentException {

    if (Integer.parseInt(memNum) < 0) {
      throw new IllegalArgumentException("ServiceRecord(): invalid memberNumber");
    } else if (Integer.parseInt(provNum) < 0) {
      throw new IllegalArgumentException("ServiceRecord(): invalid providerNumber");
    } else {

      dateOfService = dateProvided;
      dateRecorded = dateRec;
      timeRecorded = timeRec;
      memberName = memName;
      memberNumber = memNum;
      providerNumber = provNum;
      serviceCode = servCode;
      serviceFee = servFee;
      commentary = com;

    }

  }

  /**
   * This method will compile all of the service information into a string and
   * will return that string to the caller.
   * 
   * @return returns a string of the service record
   */
  public String print() {

    String stringToReturn = "";
    String currentDateAndTime = "DateRecorded: " + dateRecorded + "\n" + "TimeRecorded: " 
        + timeRecorded + "\n";
    stringToReturn += currentDateAndTime;
    stringToReturn += "dateOfService: " + dateOfService + "\n";
    stringToReturn += "memberName: " + memberName + "\n";
    stringToReturn += "ProviderNumber: " + providerNumber + "\n";
    stringToReturn += "memberNumber: " + memberNumber + "\n";
    stringToReturn += "serviceCode: " + serviceCode + "\n";
    stringToReturn += "serviceFee: " + serviceFee + "\n";
    if (!commentary.equals(null)) {
      stringToReturn += "commentary: " + commentary + "\n";
    } else {
      stringToReturn += "commentary: null\n";
    }

    return stringToReturn;
  }

  /**
   * This method is intended for use with the summaryReport.java class and will
   * return a string containing the information that class needs.
   * 
   * @return returns a string consisting of the service record
   */
  public String getServiceRecordString() {
    String stringToReturn = "@@@@";
    stringToReturn += dateOfService + "@@";
    stringToReturn += dateRecorded + " " + timeRecorded + "@@";
    stringToReturn += memberName + "@@";
    stringToReturn += memberNumber + "@@";
    stringToReturn += providerNumber + "@@";
    stringToReturn += serviceCode + "@@";
    stringToReturn += serviceFee + "@@";
    return stringToReturn;
  }

  // accessors //

  /**.
   * 
   * @return returns the member number
   */
  public String getMemberNumber() {
    return memberNumber;
  }
  
  /**
   * accessor. 
   * @return providernumber
   */
  
  public String getProviderNumber() {
    return providerNumber; 
  }
  

  /**.
   * 
   * @return returns the service code
   */
  public String getServiceCode() {
    return serviceCode;
  }

  /**.
   * 
   * @return returns the dateOfService
   */
  public String getDateOfService() {
    return dateOfService;
  }
  
  /**
   * gets the service fee.
   * @return returns the service fee
   */
  public String getServiceFee() {
    return serviceFee; 
  }
}
