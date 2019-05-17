package emersonmenus;

public class SelectMenu extends javax.swing.JFrame {

  private static final long serialVersionUID = -5260604736956738541L;
  private javax.swing.JButton providerButton;
  private javax.swing.JButton operatorButton;
  private javax.swing.JButton managerButton;

  boolean onePressed = false;

  public SelectMenu() {
    initComponents();
  }

  private void initComponents() {
    providerButton = new javax.swing.JButton();
    operatorButton = new javax.swing.JButton();
    managerButton = new javax.swing.JButton();

    providerButton.setText("Provider Login");
    operatorButton.setText("Operator Login");
    managerButton.setText("Manager Login");

    providerButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        oneButtonActionPerformed(evt);
      }
    });

    operatorButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        twoButtonActionPerformed(evt);
      }
    });

    managerButton.addActionListener(new java.awt.event.ActionListener() {
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

                .addGroup(
                    layout.createSequentialGroup().addComponent(providerButton,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGroup(
                    layout.createSequentialGroup().addComponent(operatorButton, 
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 
                        javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGroup(
                    layout.createSequentialGroup().addComponent(managerButton, 
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, 
                        javax.swing.GroupLayout.PREFERRED_SIZE)))

            .addContainerGap(150, Short.MAX_VALUE)) // how wide is the box
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, 
        new java.awt.Component[] { providerButton });

    layout.setVerticalGroup(layout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
        .createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.BASELINE).addComponent(providerButton))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.BASELINE).addComponent(operatorButton))

        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.BASELINE).addComponent(managerButton))

        .addContainerGap(50, Short.MAX_VALUE)));

    pack();

    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Selection Menu");

  }

  /**
   * This displays this menu.
   * 
   * @author Emerson
   */

  public void display() {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new SelectMenu().setVisible(true);
      }
    });

  }

  private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
    ProviderLogin menu = new ProviderLogin();
    menu.display();
    this.dispose();

  }

  private void twoButtonActionPerformed(java.awt.event.ActionEvent evt) {
    OperatorLogin menu = new OperatorLogin();
    menu.display();
    this.dispose();

  }

  private void threeButtonActionPerformed(java.awt.event.ActionEvent evt) {

    ManagerLogin menu = new ManagerLogin();
    menu.display();
    this.dispose();
  }

}
