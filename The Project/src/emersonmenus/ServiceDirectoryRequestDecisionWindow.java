package emersonmenus;

import alecservicecodes.RequestServiceCodes;
import javax.swing.JOptionPane;



public class ServiceDirectoryRequestDecisionWindow extends javax.swing.JFrame {
  
  private static final long serialVersionUID = -6854886635957995131L;

  private javax.swing.JButton oneButton;
  private javax.swing.JButton twoButton;

  public ServiceDirectoryRequestDecisionWindow() {
    initComponents();
  }

  private void initComponents() {

    oneButton = new javax.swing.JButton();
    twoButton = new javax.swing.JButton();

    oneButton.setText("Display directory");
    twoButton.setText("Send me an email with the directory in it");

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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(

        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()

            .addContainerGap(150, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                .addGroup(layout.createSequentialGroup()
                    .addComponent(oneButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGroup(layout.createSequentialGroup()
                    .addComponent(twoButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))

            .addContainerGap(150, Short.MAX_VALUE)) // how wide is the box
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { oneButton });

    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(oneButton)

            ).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(twoButton)

            )

            .addContainerGap(50, Short.MAX_VALUE)));

    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Service Directory");

  }
  /**
   * This displays a menu of this type.
   * @author Emerson
   */ 
  
  public void display() {
    // This Diplays the UI with one buttons, each one returns a different value

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ServiceDirectoryRequestDecisionWindow().setVisible(true);

      }
    });

  }

  private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
    // Display Directory
    RequestServiceCodes controller = new RequestServiceCodes();

    JOptionPane.showMessageDialog(null, controller.requestDirectoryString(), 
        "Service Code Directory",
        JOptionPane.INFORMATION_MESSAGE);
    this.dispose();
    return;
  }

  private void twoButtonActionPerformed(java.awt.event.ActionEvent evt) {
    RequestServiceCodes controller = new RequestServiceCodes();
    controller.requestDirectoryEmail(JOptionPane.showInputDialog(null, 
        "Please enter your email", "Service Emailer"));
    this.dispose();
    return;
  }

}
