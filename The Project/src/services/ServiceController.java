package services; 

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This ServiceController class, provides an interface for the user to interact with 
 * The services stored on disk.
 * 
 * @author roryoconnor
 *
 */


public class ServiceController {

  ArrayList<ServiceRecord> serviceList; 
  int numServices; 
  
  /* Constructors */ 
  SF
  /**
   * This constructor will create a new service controller object.
   */
  public ServiceController() {
  
    numServices = 0; 
  
 
    String home = System.getProperty("user.dir"); 
  
    String path = home + File.separator + "src" + File.separator + "services" 
        + File.separator + "records"; 
    
    serviceList = new ArrayList<ServiceRecord>(); 
 
    File theFolder = new File(path); 
    File[] listOfFiles = theFolder.listFiles(); 
  
    // load the files from the correct folder
    for (File file : listOfFiles) {
      if (file.isFile() && file.getName().contains(".txt")) {
 
        try {
            
          ServiceRecord newRecord; 
          newRecord = createServiceRecordFromFile(file); 
          serviceList.add(newRecord); 
          numServices++; 
            
        } catch (FileNotFoundException e) {
          System.out.print("File not found exception: "); 
          e.printStackTrace();
        }

      }
  
    }
  
  }


  /* Methods */ 

  /**
   * method to find total fees.
   * @param provNum the number we're looking for
   * @return returns the amount owed
   */
  public ArrayList<String> getTotalFeesByProvider(String provNum) {
    ArrayList<String> allFees = new ArrayList<String>();  
    for (int i = 0; i < serviceList.size(); i++) {
      ServiceRecord curService = serviceList.get(i);
      if (Integer.parseInt(curService.getProviderNumber()) == Integer.parseInt(provNum)) {
        allFees.add(curService.getServiceFee()); 
      }
    }
    return allFees; 
  }
  

  /**
   * This method will add the ServiceRecord record to the serviceList, and should
   * return true if added successfully and false when not added successfully.
   *
   * @param record the ServiceRecord object to be passed in
   * @return returns true if added correctly, false if not
   */
  public boolean addServiceRecord(ServiceRecord record) {
  
    serviceList.add(record); 
    numServices++; 
    // should write the file to the disk; 
    writeRecordToDisk(record); 
    if (serviceList.get(numServices - 1) == record) {
      return true;
    }
    return false; 
  }

  
  /**
   * This method takes 1 parameter: the serviceCode to find, it will iterate
   * through the service list until it finds a service matching that service
   * code.  If not found, it will return an empty ServiceRecord Object.
   * 
   * @param serviceCodeToFind and int storing the serviceCode we are looking for
   * @return returns the first service which matches the service code, else throws an exception
   * @throws IllegalArgumentException thrown if no service code exists
   */

  ServiceRecord getService(int serviceCodeToFind) throws IllegalArgumentException {
  
    ServiceRecord serviceToReturn = null;  
    for (int i = 0; i < serviceList.size(); i++) {
      int theNum = Integer.parseInt(serviceList.get(i).getServiceCode()); 
      if (theNum == serviceCodeToFind) {
        serviceToReturn = serviceList.get(i); 
        return serviceToReturn; 
      }
    }
    //throw IllegalArgumentException(); 
    throw new IllegalArgumentException("serviceController.getService(int serviceCode): "
        + "invalid service code"); 
  }

  
 
  
  
  
  
  /**
   * This method will iterate through the serviceList and will get each record assosciated with
   *  the given memberNumber parameter.  It will add the record to a string and return all the 
   *  records assosciated with the member.
   * 
   * @param memberNumber a string storing the member number we are looking for 
   * @return returns a string containing all the records of the member
   * @throws IllegalArgumentException thrown if it does not any records for the member number
   */
  public String getRecordsByMember(String memberNumber) throws IllegalArgumentException {
    boolean recordsFound = false; 
    String records = ""; 
    for (int i = 0; i < serviceList.size(); i++) {
      if (serviceList.get(i).memberNumber.contentEquals(memberNumber)) {
        records += serviceList.get(i).getServiceRecordString();
        recordsFound = true; 
      }
    }
    if (recordsFound == false) {
      throw new IllegalArgumentException("ServiceController.getRecordsByMember(): "
          + "provided member number doesn't exist"); 
    }
    return records; 
  }
  

  /**.
   * This method will iterate through the serviceList and will find each service 
   * associated with a provider number and add that service to the a string, at the 
   * end it will return the string.  if a record is not found it will throw an 
   * illegal argument exception.
   * 
   * @param provNum an int storing the provider number this method is searching for
   * @return returns a string of all the records found if any are found.  If no records 
     are found, throws an exception
   * @throws IllegalArgumentException thrown if no records matching the provider are found
   */
  public String getRecordsByProvider(String provNum) throws IllegalArgumentException {
    boolean recordsFound = false; 
    String records = ""; 
    for (int i = 0; i < serviceList.size(); i++) {
      
      //String theNum = serviceList.get(i).getProviderNumber(); 
      
      if (Integer.parseInt(serviceList.get(i).getProviderNumber()) == Integer.parseInt(provNum)) {
        records += serviceList.get(i).getServiceRecordString(); 
        records += "\n"; 
        recordsFound = true; 
      }
    }
    if (recordsFound) {
      return records; 
    }
    throw new IllegalArgumentException("ServiceController.getRecordsByProvider(int provNum): "
        + "invalid provider number"); 
  }


  /**
   * This method will create a file for a service record and write the information to the file.  
   * The file will be named in the following pattern: memberNumber_dateOfService.txt.
   * 
   * 
   * @param record the ServiceRecord object we would like to write to disk
   * @throws IllegalArgumentException thrown if the fileName for the service already exists
   * 
   */
  public void writeRecordToDisk(ServiceRecord record) throws IllegalArgumentException {

    String home = System.getProperty("user.dir"); 
    String path = home + File.separator + "src" + File.separator + "services" + File.separator 
        + "records"; 
    String fileName = record.getMemberNumber() + "_" + record.getDateOfService() + ".txt"; //
    path += File.separator + fileName; 
    
    
    File theFile = new File(path); 
    boolean exists = theFile.exists(); 
    FileWriter theFileWriter; 
    
    if (!exists) {
      try {
        theFileWriter = new FileWriter(theFile);
        //System.out.println(record.print()); 
        theFileWriter.write(record.print());
        theFileWriter.close(); 
      } catch (IOException e) {
        //e.printStackTrace();
        System.out.println("cannot create new file: " + e.getLocalizedMessage()); 
      } finally {
        System.out.println("finishing"); 
      }
    } else {
      throw new IllegalArgumentException("filename for service already exists, "
          + "cannot create new file"); 
    }
    
  }


  /**
   * This method iterates through the service list until it finds a service matching
   * the memberNumber parameter, at which point it will return true.  If it cannot
   * find a service matching the member number, this method will return false.
   * 
   * @param memberNumber a string storing the member number this method is looking for
   * @return returns true if a service matching the member number is found, else it returns false
   */ 
  
  public boolean exists(String memberNumber) {
    int i; 
    for (i = 0; i < serviceList.size(); i++) {
      if (Integer.parseInt(serviceList.get(i).getMemberNumber()) 
          == Integer.parseInt(memberNumber)) {
        return true; 
      } else if (Integer.parseInt(serviceList.get(i).getProviderNumber())
          == Integer.parseInt(memberNumber)) {
        return true;
      }
    }
    return false;
  }

  
  
  /**
   * This method will create a service record from the File object in the method's parameters
   * It works by reading each line of the properly formatted file and assigning it to the 
   * appropriate variable.  Example file: 
   * 
   *    <p>DateRecorded: 01-02-19
   *    TimeRecorded: 3:20PM
   *    dateOfService: 01-01-19
   *    memberName: rory
   *    ProviderNumber: 4321
   *    memberNumber: 1234
   *    serviceCode: 1181
   *    serviceFee: 26.54
   *    commentary: no
   *  
   *  <p>All that matters is that the colon is placed after each data title
   * 
   * @param file the file we're using to create the service record
   * @return
   * 
   * @throws FileNotFoundException thrown when this method can't find the file
   */
  
  ServiceRecord createServiceRecordFromFile(File file) throws FileNotFoundException {
    
    Scanner theScanner; 

    theScanner = new Scanner(file); 
    
    String newDateRecorded = theScanner.nextLine().split(" ")[1]; 
    String newTimeRecorded = theScanner.nextLine().split(" ")[1]; 

    String newDateOfService = theScanner.nextLine().split(" ")[1]; 
    
    String newMemName = theScanner.nextLine().split(" ")[1];  
    String newProvNum = theScanner.nextLine().split(" ")[1]; 
    String newMemNum = theScanner.nextLine().split(" ")[1]; 
    String newServiceCode = theScanner.nextLine().split(" ")[1]; 
    
    String newServiceFee = theScanner.nextLine().split(" ")[1]; 
    
    String newComments = null; 
    if (theScanner.hasNextLine()) {
      String nextLine = theScanner.nextLine(); 
      if (nextLine != "") {
        String[] stringArray = nextLine.split(" "); 
        if (stringArray.length > 1) {
          newComments = stringArray[1]; 
        } else {
          newComments = ""; 
        }
      }
    } else {
      newComments = null; 
    }
    
    theScanner.close(); 
   
    
    ServiceRecord newRecord = new ServiceRecord(newDateOfService, newDateRecorded, 
        newTimeRecorded, newMemName, newMemNum, newProvNum, newServiceCode, 
        newServiceFee, newComments);
    return newRecord; 
    
  }

}
