package alecservicecodes; 

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class ServiceDirectory {
  private ArrayList<Service> services;
  
  /**
   * Constructor takes the file location of a text file formatted as such:
   * code/fee/name
   * then parses through, constructing a service and placing it in services
   * for each line of the file.
   * If the file is formatted incorrectly, will throw an exception and initialize
   * with an empty services
   * 
   * @param servicesTxtFile Location of the file that holds all services
   */
  public ServiceDirectory(String servicesTxtFile) {
    services = new ArrayList<Service>();
    File file = new File(servicesTxtFile);

    //case where file doesn't exist handled by try catch, as well as bad formatting
    try {
      //constructs arraylist serv, which holds all lines of text file
      Scanner scan = new Scanner(file);
      ArrayList<String> serv = new ArrayList<String>();
      while (scan.hasNext()) {
        serv.add(scan.nextLine());
      }
        
      for (int i = 0; i < serv.size(); i++) {
        String[] s = serv.get(i).split("/");
        services.add(new Service(s[0], 
                                 s[1], 
                                 s[2]));
      }

      scan.close();
    } catch (Exception e) {
      System.out.println("Error in constructor of Service DirectoryL" + e);
    }
  }
  
  
  
  
  /**
   * Given the name of the service, this method
   * returns the entire service.
   * 
   * @param  serviceName Name of the service
   * @return returns the entire service
   */
  public Service getServiceByName(String serviceName) {
    for (int i = 0; i < services.size(); i++) {
      if (serviceName.equals(services.get(i).getName())) {
        return services.get(i);
      }
    }
      
    return null;
  }
     
  /**
   * Given the code of the service, this method
   * returns the entire service.
   * 
   * @param serviceCode The code of the service
   * @return            Returns the entire service
   */
  public Service getServiceByCode(String serviceCode) {
    for (int i = 0; i < services.size(); i++) {
      if (serviceCode.equals(services.get(i).getCode())) {
        return services.get(i);
      }
    }
      
    return null;
  }
  
  
  /**
   * This method compiles all the prints of stored services
   * into one formatted string.
   * 
   * @return Returns the compiled string
   */
  public String print() {
    String s = "";
      
    for (int i = 0; i < services.size(); i++) {
      s = s + services.get(i).print() + "\n";
    }
      
    return s;
  }
}