package emersonmenus;

import elleuser.Member;
import elleuser.MemberController;
import javax.swing.JOptionPane;


public class MemberValidatorWindow extends javax.swing.JFrame {
 
  private static final long serialVersionUID = -6518058318517825886L;
  private javax.swing.JButton loginButton;
  private javax.swing.JTextField numberField;

  boolean onePressed = false;

  public MemberValidatorWindow() {
    initComponents();
  }

  private void initComponents() {

    loginButton = new javax.swing.JButton();
    numberField = new javax.swing.JTextField(15);

    loginButton.setText("Validate");

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

            .addGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(loginButton)

            ).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                .addComponent(numberField,
                    javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE))

            .addContainerGap(50, Short.MAX_VALUE)));

    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Member Validator");

  }
  /**
  * This is the method used to display a window of tis type to the user.
  * @author Emerson
  */
  
  public void display() {
    // This Diplays the UI with one button and a text field

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MemberValidatorWindow().setVisible(true);

      }
    });

  }

  private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String potentialMemberNumber = numberField.getText();

    String memberIsValid = "2";
    MemberController controller = new MemberController();
    Member potentialMember = controller.searchByNum(potentialMemberNumber);
    if (potentialMember == null) {
      memberIsValid.contentEquals("2");// member does not exist
    } else {
      memberIsValid = potentialMember.getSuspendStatus(); // 0 is valid and 1 is suspended
    }

    if (memberIsValid.contentEquals("0")) { // Is valid
      JOptionPane.showMessageDialog(null, 
          "Member Is Valid", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    if (memberIsValid.contentEquals("1")) { // is suspended
      this.dispose();
      JOptionPane.showMessageDialog(null, 
          "Member is Supsended Due To Unpaid Dues", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (memberIsValid.contentEquals("2")) { // does not exist 
      this.dispose();
      JOptionPane.showMessageDialog(null, 
          "Member does not exist", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

    ProviderMenu menu = new ProviderMenu();
    menu.display();

    this.dispose();
    return;

  }

}
