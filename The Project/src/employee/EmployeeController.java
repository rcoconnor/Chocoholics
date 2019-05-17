package employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {

  /* Data Members */

  ArrayList<Employee> loginArray;
  int numEmployees;

  /* Constructors */
  /**
   * Constructor for EmployeeController.
   */
  public EmployeeController() {

    loginArray = new ArrayList<Employee>();
    numEmployees = 0;

    Scanner theScanner;

    String home = System.getProperty("user.dir");
    String path = home + File.separator + "src" + File.separator + "employee" 
        + File.separator + "records";

    File theFolder = new File(path);
    File[] listOfFiles = theFolder.listFiles();
    for (File file : listOfFiles) {
      if (file.isFile() && file.getName().contains(".txt")) {

        try {

          theScanner = new Scanner(file);
          String newId;
          while (theScanner.hasNextLine()) {
            String newIdString = theScanner.nextLine();
            if (newIdString != "") {

              newId = newIdString;
              if (!doesExist(newId)) {
                Employee newEmp = new Employee(newId);
                loginArray.add(newEmp);
                numEmployees++;
              }

            }
          }
        } catch (FileNotFoundException e) {
          System.out.print("File not foun exception: ");
          // e.printStackTrace();
        } catch (NumberFormatException e) {
          // System.out.print("numberformatException: ");
          // e.printStackTrace();
        }

      }

    }

  }

  /* Methods */


  /**
   * This method will iterate through each employee in loginArray[] and check if
   * their ID is the same as the ID supplied.
   * @param newEmp the new employee to add to the loginArray
   * @throws IllegalArgumentException thrown if the employee number already exists
   */
  
  public void addEmployee(Employee newEmp) throws IllegalArgumentException {

    // System.out.println("adding: " + newEmp.getId());

    if (doesExist(newEmp.getId())) {
      throw new IllegalArgumentException("employe number " + newEmp.getId() + " already exists");
    }

    try {
      String path = System.getProperty("user.dir") + File.separator + "src" 
          + File.separator + "employee" + File.separator + "records" + File.separator 
            + "employeelist.txt";
      FileWriter fw = new FileWriter(path, true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter out = new PrintWriter(bw);

      out.println(newEmp.getId() + "\n");
      out.close();

    } catch (IOException e) {
      System.out.print("IOException in EmployeeController.addEmployee(" + newEmp.getId() + "): ");
      e.printStackTrace();
    }

    loginArray.add(newEmp);
    numEmployees++;

  }

  /**
   * Method to check whether the employee exists in loginArray.
   * @param employeeNumber the number of the employee to check if they exist
   * @return
   */
  
  public boolean doesExist(String employeeNumber) {

    for (int i = 0; i < loginArray.size(); i++) {

      if (Integer.parseInt(loginArray.get(i).getId()) == Integer.parseInt(employeeNumber)) {
        return true;
      }

    }
    return false;
  }

}
