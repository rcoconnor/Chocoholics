package reportcodesryan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SummaryReport extends Report {

  double totalFee;
  int totalConsultations;

  /**
   * Constructor sets the current date and file path.
   */
  
  public SummaryReport() {
    this.listOfServices = new ArrayList<String[]>();
    totalFee = 0;
    totalConsultations = 0;
    
    setDate();
    home = System.getProperty("user.dir");
    path = home + File.separator + "src" + File.separator + "reportcodesryan" + File.separator
            + "Summary_Reports" + File.separator + "summary_report_" + reportDate + ".txt";
    file = new File(path);
  }

  /**
   * This method adds the new provider and their information to the listOfServices.
   * @param name - name of the provider.
   * @param fees - list of all fees owed to the provider.
   */
  
  public void addSum(String name, ArrayList<String> fees) {
    String[] service = new String[9];
    int consultations = fees.size();
    double weekFees = 0;
    service[8] = name;
    service[7] = Integer.toString(consultations);

    for (int i = 0; i < fees.size(); i++) {
      weekFees += Double.parseDouble(fees.get(i));
    }
    service[6] = Double.toString(weekFees);
    
    listOfServices.add(service);

    totalFee += weekFees;
    totalConsultations += consultations;
  }
  
  /**
   * Prints the summary report.
   * @throws IOException - for fileWriter.
   * 
   */
  
  public void print() throws IOException {
    sortServices();
    System.out.println(listOfServices.size());
    if (file.createNewFile()) {
        //File created!
    } else { 
      System.out.println("Overwriting previous file");
    }
    FileWriter fw;
    try {
      fw = new FileWriter(file);
      BufferedWriter bw = new BufferedWriter(fw);
        
      for (int i = 0; i < listOfServices.size(); i++) {
        bw.write("Provider name: " + listOfServices.get(i)[8] + "\n");
        bw.write("  Number of Consultations: " + listOfServices.get(i)[7] + "\n");
        bw.write("  Total fee: " + listOfServices.get(i)[6] + "\n");
        bw.write("-------------------------------------- \n");
      }
      bw.write("-------------------------------------- \n");
      bw.write("Total Providers: " + listOfServices.size() + "\n");
      bw.write("Total Consultations: " + totalConsultations + "\n");
      bw.write("Total Fees: " + totalFee);
        
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  /**
   * Sorts all the services by name before printing.
   */
  
  private void sortServices() {
    Collections.sort(listOfServices,new Comparator<String[]>() {
      public int compare(String[] strings, String[] otherStrings) {
        return strings[8].compareTo(otherStrings[8]);
      }
    });
  }
}
