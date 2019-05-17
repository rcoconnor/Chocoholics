package reportcodesryan;

import alecservicecodes.RequestServiceCodes;
import elleuser.MemberController;
import elleuser.ProviderController;
import java.io.IOException;
import java.util.ArrayList;
import services.ServiceController;


public class ReportWriter {

  /**
   * Basic constructor.
   */

  public ReportWriter() {
     
  }

  /**
   * This method handles writing the member report.
   * @param memberNumber This is the number of the member for whom we are generating the report.
 * @throws IOException for writeFile.
   */
  
  public void writeMemberReport(String memberNumber) throws IOException {
    
    //Initialize class objects//
    MemberController memberController = new MemberController();
    
    String name = memberController.getNameByNum(memberNumber);
    MemberReport memberReport = new MemberReport(memberController.getInfo(memberNumber), name);
    RequestServiceCodes serviceGetter = new RequestServiceCodes();
    ServiceController serviceController = new ServiceController();
    ProviderController providerController = new ProviderController();
    
    //Initialize method attributes//
    String[] service = new String[9];
    int lastIndex;

    //Gets a string of all the service records associated with that member//
    String serviceList = null;
    try {
      serviceList = serviceController.getRecordsByMember(memberNumber);
    } catch (IllegalArgumentException e) {
      throw e;
    }
    
    //Iterate through serviceList to gather and add all the services//
    for (int firstIndex = 0; firstIndex < serviceList.length(); firstIndex++) {
      firstIndex = firstIndex + 1;
      lastIndex = serviceList.indexOf("@@", firstIndex + 3);
      
      for (int j = 0; j < 7; j++) {
        service[j] = serviceList.substring(firstIndex + 2, lastIndex);
        firstIndex = lastIndex;
        lastIndex = serviceList.indexOf("@@", lastIndex + 2);
      }
      service[7] = serviceGetter.requestNameByCode(service[5]);
      service[8] = providerController.getNameByNumber(service[4]);
      memberReport.addService(service, true);
      firstIndex = firstIndex + 2;
    }

    //print the report//
    memberReport.print();
    return;
  }

  /**
   * This method handles writing the provider reports.
   * @param providerNumber The number of the provider for whom we're generating the report.
   * @throws IOException for writeFile.
   */
  
  public void writeProviderReport(String providerNumber) throws IOException {
    //Initiate class objects//
    ProviderController providerController = new ProviderController();
    String name = providerController.getNameByNumber(providerNumber);
    ProviderReport providerReport = 
        new ProviderReport(providerController.getInfo(providerNumber), name);
    ServiceController serviceController = new ServiceController();
    
    //Initiate method attributes//
    String[] service = new String[9];
    int lastIndex;

    //Get list of services associated with the provider number//
    String serviceList = null;
    try {
      serviceList = serviceController.getRecordsByProvider(providerNumber);
    } catch (IllegalArgumentException e) {
      throw e;
    }

    //Iterate through serviceList to gather and add all the services//
    for (int firstIndex = 0; firstIndex < serviceList.length(); firstIndex++) {
      firstIndex = firstIndex + 1;
      lastIndex = serviceList.indexOf("@@", firstIndex + 3);
      for (int j = 0; j < 7; j++) {
        service[j] = serviceList.substring(firstIndex + 2, lastIndex);
        firstIndex = lastIndex;
        lastIndex = serviceList.indexOf("@@", lastIndex + 2);
      }
      providerReport.addService(service, false);
      firstIndex = firstIndex + 2;
    }
    
    //Print the report//
    providerReport.print();
  }

  /**
   * This function runs a the summary for all of the providers.
   * @throws IOException for writeFile.
   */
  
  public void writeSummaryReport() throws IOException {
    //Initiate class objects//
    SummaryReport summaryReport = new SummaryReport();
    ProviderController providerController = new ProviderController();
    ServiceController serviceController = new ServiceController();
    
    //Initiate method attributes//
    ArrayList<String> providerList = providerController.getAllProviderNumbers();
    String name;
    ArrayList<String> fees = new ArrayList<String>();
    
    //Iterate through all the provider numbers and add all associated services//
    for (int i = 0; i < providerList.size(); i++) {
      name = providerController.getNameByNumber(providerList.get(i));
      fees = serviceController.getTotalFeesByProvider(providerList.get(i));

      if (fees.size() != 0) {               //If there are no services don't add the provider
        summaryReport.addSum(name, fees);
      }
    }
    
    //Print report//
    summaryReport.print();
    return;
  }

  /**
   * This function prepares and writes the EFT reports.
   * @throws IOException - for writeFile.
   */

  public void writeEftReport() throws IOException {
    //Initiate class objects//
    EftReport eftReport = new EftReport();
    ProviderController providerController = new ProviderController();
    ServiceController serviceController = new ServiceController();
    
    //Initiate method attributes//
    ArrayList<String> providerList = providerController.getAllProviderNumbers();
    String name;
    ArrayList<String> fees = new ArrayList<String>();
    
    //Iterate through all the provider numbers and add all associated services//
    for (int i = 0; i < providerList.size(); i++) {
      name = providerController.getNameByNumber(providerList.get(i));
      fees = serviceController.getTotalFeesByProvider(providerList.get(i));

      if (fees.size() != 0) {               //If there are no services don't add the provider
        eftReport.addEftData(providerList.get(i), name, fees);
      }
    }

    //Print report//
    eftReport.printEft();
    return;
  }
  
}
