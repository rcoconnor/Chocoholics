package emersonmenus;

import elleuser.MemberController;
import elleuser.ProviderController;
import java.io.IOException;
import javax.swing.JOptionPane;
import reportcodesryan.ReportWriter;


public class ManagerMenu extends javax.swing.JFrame {
  /**
   * .
   * @author Emerson
   */
  private static final long serialVersionUID = -6854886635957995131L;

  private javax.swing.JButton oneButton;
  private javax.swing.JButton twoButton;
  private javax.swing.JButton threeButton;

  boolean onePressed = false;

  public ManagerMenu() {
    initComponents();
  }

  private void initComponents() {

    oneButton = new javax.swing.JButton();
    twoButton = new javax.swing.JButton();
    threeButton = new javax.swing.JButton();

    oneButton.setText("Run Individual Member Report");
    twoButton.setText("Run Individual Provider Report");
    threeButton.setText("Run Current Summary Report");

    oneButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        oneButtonActionPerformed(evt);
      }
    });

    twoButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        twoButtonActionPerformed(evt);
      }
    });

    threeButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        threeButtonActionPerformed(evt);
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

                .addGroup(layout.createSequentialGroup()
                    .addComponent(oneButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGroup(layout.createSequentialGroup()
                    .addComponent(twoButton,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGroup(
                    layout.createSequentialGroup()
                    .addComponent(threeButton,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))

            )

            .addContainerGap(150, Short.MAX_VALUE)) // how wide is the box
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { oneButton });

    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
            .addGroup(
                layout.createParallelGroup(
                    javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(oneButton)

            ).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(twoButton)
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(threeButton))
            .addContainerGap(50, Short.MAX_VALUE)));
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Manager Menu");

  }

  /**
  * This is the method used to create a window of this type.
  * @author Emerson
  */
  public int display() {
    // Call this function to create a window of this type
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ManagerMenu().setVisible(true);

      }
    });

    return 0;
  }

  private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
    ReportWriter writer = new ReportWriter();
    MemberController controller = new MemberController();
    String memberNumber = JOptionPane.showInputDialog(
        "Please enter the Member Number", "Report Writer");

    try {
      Integer.parseInt(memberNumber);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, 
          "That is not a number", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (!controller.validateMember(memberNumber)) {
      JOptionPane.showMessageDialog(null, "No Member with That Number Exists", "ERROR",
          JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    try {
      writer.writeMemberReport(memberNumber);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "IO exception", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

  }

  private void twoButtonActionPerformed(java.awt.event.ActionEvent evt) {
    ReportWriter writer = new ReportWriter();
    ProviderController controller = new ProviderController();
    String providerNumber = JOptionPane.showInputDialog(
        "Please enter the Provider Number", "Report Writer");

    try {
      Integer.parseInt(providerNumber);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, 
          "That is not a number", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (!controller.validateProvider(providerNumber)) {
      JOptionPane.showMessageDialog(null, "No Provider with That Number Exists", "ERROR",
          JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    try {
      writer.writeProviderReport(providerNumber);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "IO exception", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

  }

  private void threeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    ReportWriter writer = new ReportWriter();
    try {
      writer.writeSummaryReport();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "IO exception", "ERROR", JOptionPane.ERROR_MESSAGE);

    }
    JOptionPane.showMessageDialog(null,
        "Report Queued!", "Success", JOptionPane.INFORMATION_MESSAGE);

  }

}
