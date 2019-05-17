package emersonmenus;

public class ProviderMenu extends javax.swing.JFrame {
 
  private static final long serialVersionUID = -6854886635957995131L;

  private javax.swing.JButton oneButton;
  private javax.swing.JButton twoButton;
  private javax.swing.JButton threeButton;

  boolean onePressed = false;

  public ProviderMenu() {
    initComponents();
  }

  private void initComponents() {

    oneButton = new javax.swing.JButton();
    twoButton = new javax.swing.JButton();
    threeButton = new javax.swing.JButton();

    oneButton.setText("Validate Member");
    twoButton.setText("Request Provider Directory");
    threeButton.setText("Bill for Health-Care services");

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
                    .addComponent(oneButton, 
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 
                        javax.swing.GroupLayout.PREFERRED_SIZE))

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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(oneButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(twoButton))

            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(threeButton))

            .addContainerGap(50, Short.MAX_VALUE)));

    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Provider Menu");

  }

  /**
   * This creates and displays a window of this type.
   * @author Emerson
   */

  public void display() {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ProviderMenu().setVisible(true);

      }
    });
  }

  private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
    // Validate Member
    MemberValidatorWindow window = new MemberValidatorWindow();
    window.display();
  }

  private void twoButtonActionPerformed(java.awt.event.ActionEvent evt) {
    // Request Service Directory
    ServiceDirectoryRequestDecisionWindow window = new ServiceDirectoryRequestDecisionWindow();
    window.display();
  }

  private void threeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    BillForHealthCareForm window = new BillForHealthCareForm();
    window.display();
  }

}
