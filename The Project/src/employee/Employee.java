package employee;

public class Employee {

  String idNum;

  /* Constructors */

  /**
   * Constructor constructs a new employee class.
   * 
   * @param newIdNum the new id number to assign to the employee
   * @throws IllegalArgumentException thrown if newIdNum is negative
   */
  public Employee(String newIdNum) throws IllegalArgumentException {
    if (Integer.parseInt(newIdNum) < 0) {
      throw new IllegalArgumentException("Error: ID numbers cannot be negative");
    }
    idNum = newIdNum;
  }

  
  /**
   * overloaded constructor.
   * 
   * @param newIdNum the new id number 
   * @throws IllegalArgumentException thrown if the number is negative
   */
  public Employee(int newIdNum) throws IllegalArgumentException {
    if (newIdNum < 0) {
      throw new IllegalArgumentException("Error: ID numbers cannot be negative)");
    }
    idNum = Integer.toString(newIdNum);
  }

  /**
   * Sets the ID.
   * 
   * @param newIdNum the new Id to set
   * @throws IllegalArgumentException thrown if newIdNum is negative
   */
  public void setId(String newIdNum) throws IllegalArgumentException {
    if (Integer.parseInt(newIdNum) < 0) {
      throw new IllegalArgumentException("Error: ID numbers can not be negative");
    }
    idNum = newIdNum;
    return;
  }

  public String getId() {
    return idNum;
  }

}
