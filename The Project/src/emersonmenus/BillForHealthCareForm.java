package emersonmenus;

import alecservicecodes.RequestServiceCodes;
import alecservicecodes.Service;
import elleuser.Member;
import elleuser.MemberController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import services.ServiceController;
import services.ServiceRecord;


public class BillForHealthCareForm extends javax.swing.JFrame {
  /**
   * health care form.
   */
  private static final long serialVersionUID = -6854886635957995131L;

  private javax.swing.JLabel label;
  private javax.swing.JButton button;
  private javax.swing.JTextField textField;
    
  private String serviceCode;
  private String serviceRecordedDate;
  private String providerNumber;
  private String memberNumber;
  private String commentString;
    
  public BillForHealthCareForm() {
    initComponents();
  }
    
    
  private void initComponents() {
            
    label = new javax.swing.JLabel();
    button = new javax.swing.JButton();
    textField = new JTextField(15);
        
    label.setText("Enter Code of Service Provided");
    button.setText("Submit");
    textField.setText("");
        
        
        
    button.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonActionPerformed(evt);
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
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 
                                javax.swing.GroupLayout.DEFAULT_SIZE, 
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                       )
                    
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 
                                javax.swing.GroupLayout.DEFAULT_SIZE, 
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                       )
                    
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 
                                javax.swing.GroupLayout.DEFAULT_SIZE, 
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                    
                    )
                    
                    .addContainerGap(150, Short.MAX_VALUE)) //how wide is the box
    );
                
    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {label});
        
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label)
                       
                )
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button)                  
                         
                )
                              
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textField)
                )
                
                
                .addContainerGap(50, Short.MAX_VALUE))
    );
    
        
    pack();         
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Health Care Window");
        
  }

  /**
   * displays.  
   * @return
   */
  public int display() {
    //Call this function to create a window of this type
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new BillForHealthCareForm().setVisible(true);
        }
      });
        
    return 0;
  }


  private void buttonActionPerformed(java.awt.event.ActionEvent evt) {    
    memberNumber = JOptionPane.showInputDialog("Member Validation", 
            "Please enter the Member Number");
    if (memberNumber == null) {
      return;
    }
        
    //Validate member number here
    String memberIsValid = "2";
    MemberController controller = new MemberController();
    Member potentialMember = controller.searchByNum(memberNumber);
    if (potentialMember == null) {
      memberIsValid.contentEquals("2");//member does not exist 
    } else {
      memberIsValid = potentialMember.getSuspendStatus(); //0 is valid and 1 is suspended
    }
        
    String memberName = "John Smith";
    
    if (memberIsValid.contentEquals("0")) {
      //is valid
      this.dispose();
      JOptionPane.showMessageDialog(null,"Member Is Valid", 
              "Success", JOptionPane.INFORMATION_MESSAGE);
      memberName = controller.getNameByNum(memberNumber);
    }
    if (memberIsValid.contentEquals("1")) {
      //is suspended
      JOptionPane.showMessageDialog(null,"Member is Supsended Due To Unpaid Dues", 
              "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    if (memberIsValid.contentEquals("2")) {
      //does not exist
      JOptionPane.showMessageDialog(null,"Member does not exist", 
              "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
                
    serviceCode = textField.getText();
        
    RequestServiceCodes serviceController = new RequestServiceCodes();
    Service service = serviceController.requestServiceByCode(serviceCode);
    if (service == null) {
      JOptionPane.showMessageDialog(null,"That service does not exist", 
                "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    final String serviceFee = service.getFee();
            
    int reply = JOptionPane.showConfirmDialog(null, 
            "Is this the name of your service:" + service.getName(), 
            getTitle(), JOptionPane.YES_NO_OPTION);
    
    //yes is 0
    //no is 1
    if (reply == 1) {
      this.dispose();
      new BillForHealthCareForm().setVisible(true);
      return;
    }
    //otherwise they have verified the code
    
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    SimpleDateFormat ghf = new SimpleDateFormat("kk:mm:ss");    
    final String date = sdf.format(cal.getTime());
    final String time = ghf.format(cal.getTime());
        
    serviceRecordedDate = JOptionPane.showInputDialog("Today's Date", 
            "Please enter todays date in MM-DD-YY");
    if (serviceRecordedDate == null) {
      return;
    }
    providerNumber = JOptionPane.showInputDialog("Provider Number entry form", 
            "Please enter your Provider Number");
    if (providerNumber == null) {
      return;
    }
            
    reply = JOptionPane.showConfirmDialog(null, "Would you like to add comments?",
            "Comment Decision Form", JOptionPane.YES_NO_OPTION);
    commentString = "";
       
    if (reply == 0) {
      commentString = JOptionPane.showInputDialog("Comment Entry Form", 
              "Please enter your comments(only 100 character will be recorded)");
      if (commentString.length() > 100) {
        commentString = commentString.substring(0,99);
      }
            
    }
        
    ServiceController servicecontroller = new ServiceController();
                    
    if (commentString == null) {
      commentString = "no comment was recorded";
    }
    
    JOptionPane.showMessageDialog(null,"The Fee for this service is: $" + serviceFee, 
            "Fee", JOptionPane.INFORMATION_MESSAGE);
        
    ServiceRecord record = new ServiceRecord(serviceRecordedDate, date, time, memberName,
                memberNumber, providerNumber,  serviceCode, serviceFee, commentString);
        
    servicecontroller.addServiceRecord(record);
        
    this.dispose();
    return;
  }
}
