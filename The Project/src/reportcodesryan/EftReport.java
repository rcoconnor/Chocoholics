package reportcodesryan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EftReport extends Report {

  /**
   * Constructor. Gets the current date.
   */

  public EftReport() {
    this.listOfServices = new ArrayList<String[]>();

    setDate();
    home = System.getProperty("user.dir");
  }

  /**
   * Adds a provider to the listOfServices so that an EFT report may be compiled for them.
   * @param number - Provider number.
   * @param name - Provider name.
   * @param fees - Total provider fees owed.
   */
  
  public void addEftData(String number, String name, ArrayList<String> fees) {
    String[] service = new String[9];
    int consultations = fees.size();
    double weekFees = 0;
    service[8] = name;
    service[7] = Integer.toString(consultations);
    service[4] = number;

    for (int i = 0; i < fees.size(); i++) {
      weekFees += Double.parseDouble(fees.get(i));
    }
    service[6] = Double.toString(weekFees);
    
    listOfServices.add(service);
  }
  
  /**
   * The method to print the EFT reports.
   * @throws IOException - for fileWriter.
   */
  
  public void printEft() throws IOException {
    sortServices();
    
    for (int i = 0; i < listOfServices.size(); i++) {
      path = home + File.separator + "src" + File.separator + "reportcodesryan" + File.separator 
        + "EFT_reports" + File.separator + listOfServices.get(i)[8] + "_" + reportDate + ".txt";
      file = new File(path);

      if (file.createNewFile()) {
        //File created!
      } else {
        System.out.println("Overwriting previous file");
      }
      
      FileWriter fw;
      try {
        fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
      
        bw.write("Provider name: " + listOfServices.get(i)[8] + "\n");
        bw.write("Provider number: " + listOfServices.get(i)[4] + "\n");
        bw.write("  Fee to be transferred: " + listOfServices.get(i)[6]);
      
        bw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  private void sortServices() {
    Collections.sort(listOfServices,new Comparator<String[]>() {
      public int compare(String[] strings, String[] otherStrings) {
        return strings[8].compareTo(otherStrings[8]);
      }
    });
  }
}

