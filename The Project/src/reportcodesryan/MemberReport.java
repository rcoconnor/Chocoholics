package reportcodesryan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MemberReport extends Report {

  private String info;

  /**
   * Constructor with all member information present.
   * @param memberInfo A string of all the member's information necessary for the report.
   */
  
  public MemberReport(String memberInfo, String name) {
    this.listOfServices = new ArrayList<String[]>(); 
    info = memberInfo;
    
    setDate();
    home = System.getProperty("user.dir");
    path = home + File.separator + "src" + File.separator + "reportcodesryan" 
            + File.separator + "Member_Reports" + File.separator + name + "_" + reportDate + ".txt";
    file = new File(path);
  }
  
  
  /**
   * Method prints the report to a new file.
   * @throws IOException  from writeFile.
   */
  
  public void print() throws IOException {
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
        bw.write("  " + listOfServices.get(i)[0] + "\n");
        bw.write("  " + listOfServices.get(i)[8] + "\n");
        bw.write("  " + listOfServices.get(i)[7] + "\n");
        bw.write("-------------------------------------- \n");
      }
      
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return;
  }

  /**
   * Prints off the member information.
   * @throws IOException from writeFile.
   */
  
  private void printInfo() throws IOException {
    // DO THE THROW THING IF THERE IS NO INFO :D
    String[] titles = {"Member Name: ", "Member Street Address: ", "Member City: ",
      "Member State: ", "Member Number: ", "Member ZIP code: "};
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

