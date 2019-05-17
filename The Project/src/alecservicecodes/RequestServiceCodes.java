package alecservicecodes;

import java.io.File;

import javax.swing.JOptionPane;

//import services.ServiceRecord;
 
public class RequestServiceCodes {
  //used to count how many times the directory has been mailed
  private int directoryNum;
  //contains all services
  private ServiceDirectory directory;
  private final String servicesTxtFile = "servicesTxtFile.txt";
  
    
  /**
   * Builds the controller with hardcoded information, so that
   * no parameters need be passed. Accesses servicesTxtFile.txt
   * to make directory and counts number of elements in Emails
   * to initialize directoryNum.
   */
  public RequestServiceCodes() {
    String h1 = System.getProperty("user.dir");
    String p1 = h1 + File.separator
            + "src" + File.separator
            + "alecservicecodes" + File.separator 
            + servicesTxtFile;
    directory = new ServiceDirectory(p1);
    
    
    String h2 = System.getProperty("user.dir");
    String p2 = h2 + File.separator
            + "src" + File.separator
            + "alecservicecodes" + File.separator
            + "Emails";
    File f2 = new File(p2);
    directoryNum = f2.listFiles().length;
  }
  
    
  public String requestDirectoryString() {
    return directory.print();
  }
  
  
  public Service requestServiceByCode(String serviceCode) {
    return directory.getServiceByCode(serviceCode);
  }
  
  public String requestNameByCode(String serviceCode) {
    return directory.getServiceByCode(serviceCode).getName();
  }
    
  Service requestServiceByName(String serviceName) {
    return directory.getServiceByName(serviceName);
  }
  
  /**
   * Takes the directory string and directs it to EmailHandler.
   * 
   * @param providerEmail The email of the provider
   */
  public void requestDirectoryEmail(String providerEmail) {
    String title = "Emails\\DirectoryEmail" + directoryNum;
    directoryNum++;
      
    String contents = directory.print();
      
    if (EmailHandler.saveEmailTxt(contents, title, providerEmail)) {
      JOptionPane.showMessageDialog(null, "Email Successfully Saved!", 
                                   "Success", JOptionPane.PLAIN_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Email Not Successfully Saved", 
                                   "Failure", JOptionPane.ERROR_MESSAGE);
    }
  }
}