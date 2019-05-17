package emersonmenus;

//import elleuser.*;

public class MenusTestMain {
  /**
   * the main function.
   * @param args the arguments
   * @author Emerson
   */
  public static void main(String[] args) {
    /**
     * This generates the accounting procedure thread.
     * 
     */
    /// *
    AccountingProcedure procedure = new AccountingProcedure();
    new Thread(procedure).start();
    // */
      
    /// *
    /**
     * This begins the guis.
     */
    SelectMenu select = new SelectMenu();
    select.display();
    // */

  }

}
