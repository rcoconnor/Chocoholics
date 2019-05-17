package emersonmenus;

import employee.EmployeeController;
import javax.swing.JOptionPane;

public class OperatorLogin extends javax.swing.JFrame {
 
  private static final long serialVersionUID = -6518058318517825886L;
  private javax.swing.JButton loginButton;
  private javax.swing.JTextField numberField;

  boolean onePressed = false;

  public OperatorLogin() {
    initComponents();
  }

  private void initComponents() {

    loginButton = new javax.swing.JButton();
    numberField = new javax.swing.JTextField(15);

    loginButton.setText("Login");

    loginButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        oneButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(

        layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()

            .addContainerGap(150, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                .addGroup(
                    layout.createSequentialGroup().addComponent(loginButton, 
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 
                        javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGroup(
                    layout.createSequentialGroup().addComponent(numberField, 
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))

            ).addContainerGap(150, Short.MAX_VALUE)) // how wide is the box
    );

    layout.linkSize(
        javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { loginButton });

    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()

            .addContainerGap(50, Short.MAX_VALUE)

            .addGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(loginButton)

            ).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

            .addContainerGap(50, Short.MAX_VALUE)));

    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Operator Login");

  }

  /**
   * This method creates a window of this type and displays it.
   * @author Emerson
   */
  public int display() {

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new OperatorLogin().setVisible(true);

      }
    });

    return 0;
  }

  private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
    EmployeeController controller = new EmployeeController();
    String loginID = numberField.getText();

    if (loginID.contentEquals("Admin")) {
      JOptionPane.showMessageDialog(null,
          "Admin Login", "Success", JOptionPane.INFORMATION_MESSAGE);

      OperatorMenu menu = new OperatorMenu();
      menu.display();
      this.dispose();
      return;
    }
    try {
      Integer.parseInt(loginID);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, 
          "That is not a number", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (controller.doesExist(loginID)) {
      JOptionPane.showMessageDialog(null,
          "Successfully Logged In", "Success", JOptionPane.INFORMATION_MESSAGE);

      OperatorMenu menu = new OperatorMenu();
      menu.display();
      this.dispose();
      return;
    } else {
      JOptionPane.showMessageDialog(null, "Incorrect Login", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

  }

}