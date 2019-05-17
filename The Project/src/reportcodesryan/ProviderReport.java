package reportcodesryan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProviderReport extends Report {

  //@SuppressWarnings("unused")
  private String info;
  
  /**
   * Class constructor for Provider Report. It will initialize the date of the report.
   * @param providerInfo Information necessary for creation of the provider report.
   * @param name name of the provider to be used in the creation of the file name.
   */
  public ProviderReport(String providerInfo, String name) {
    this.listOfServices = new ArrayList<String[]>();
    info = providerInfo;
    
    setDate();
    home = System.getProperty("user.dir");
    path = home + File.separator + "src" + File.separator + "reportcodesryan" + File.separator
            + "Provider_Reports" + File.separator + name + "_" + reportDate + ".txt";
    file = new File(path);
  }
  
  /**
   * This method prints the report to a new file.
   * @throws IOException from write file
   */
  
  public void print() throws IOException {
    double feeCounter = 0;
    
    if (file.createNewFile()) {
        //File created!
    } else { 
        //File not created :(
    }
    printInfo();
    FileWriter fw;
    try {
      fw = new FileWriter(file, true);
      BufferedWriter bw = new BufferedWriter(fw);
        
      bw.write("-------------------------------------- \n");
      bw.write("-------------------------------------- \n");
      for (int i = 0; i < listOfServices.size(); i++) {
        for (int j = 0; j < 8; j++) {
          if (j == 4) {
            j++;
          }
          if (j == 6) {
            feeCounter += Double.parseDouble(listOfServices.get(i)[j]);
          }
          bw.write("  " + listOfServices.get(i)[j] + "\n");
        }
        bw.write("-------------------------------------- \n");
      }
      bw.write("-------------------------------------- \n");
      bw.write("Number of Consultations: " + listOfServices.size() + "\n");
      bw.write("Total Fee: " + feeCounter);
        
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method used by print().
   * Prints off the Provider information.
   */
  
  private void printInfo() {
    // DO THE THROW THING IF THERE IS NO INFO :D
    String[] titles = {"Provider Name: ", "Provider Street Address: ", "Provider City: ",
      "Provider State: ", "Provider Number: ", "Provider ZIP code: "};
    int firstIndex = 0;
    int lastIndex = 0;
    
    FileWriter fw;
    try {
      fw = new FileWriter(file);
      BufferedWriter bw = new BufferedWriter(fw);
     
      for (int i = 0; i < 6; i++) {
        lastIndex = info.indexOf("@@", firstIndex);
        bw.write(titles[i] + info.substring(firstIndex,lastIndex) + "\n");
        firstIndex = lastIndex + 2;
      }
      
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return;
  }
}

