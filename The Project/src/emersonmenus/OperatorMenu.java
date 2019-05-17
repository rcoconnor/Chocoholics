package emersonmenus;

import elleuser.Member;
import elleuser.MemberController;
import elleuser.Provider;
import elleuser.ProviderController;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OperatorMenu extends javax.swing.JFrame {
  /**
  * This is a class that displays a menu with six buttons: add, edit, and remove 
  * for both provider and member.
  * @author Emerson
  */ 
  private static final long serialVersionUID = -6854886635957995131L;

  private javax.swing.JButton oneButton;
  private javax.swing.JButton twoButton;
  private javax.swing.JButton threeButton;
  private javax.swing.JButton fourButton;
  private javax.swing.JButton fiveButton;
  private javax.swing.JButton sixButton;

  boolean onePressed = false;
  
  /**
   * This is the constructor for the menu
   * it calls initcomponents, which generates the window.
   */
  public OperatorMenu() {
    initComponents();
  }


  private void initComponents() {
    oneButton = new javax.swing.JButton();
    twoButton = new javax.swing.JButton();
    threeButton = new javax.swing.JButton();
    fourButton = new javax.swing.JButton();
    fiveButton = new javax.swing.JButton();
    sixButton = new javax.swing.JButton();

    oneButton.setText("Add Member");
    twoButton.setText("Remove Member");
    threeButton.setText("Edit Member Information");
    fourButton.setText("Add Provider");
    fiveButton.setText("Remove Provider");
    sixButton.setText("Edit Provider Information");

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

    fourButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fourButtonActionPerformed(evt);
      }
    });
    
    fiveButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fiveButtonActionPerformed(evt);
      }
    });

    sixButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sixButtonActionPerformed(evt);
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
        javax.swing.GroupLayout.DEFAULT_SIZE, 
        javax.swing.GroupLayout.PREFERRED_SIZE)
        )
        .addGroup(layout.createSequentialGroup()
        .addComponent(twoButton, javax.swing.GroupLayout.PREFERRED_SIZE,
        javax.swing.GroupLayout.DEFAULT_SIZE, 
        javax.swing.GroupLayout.PREFERRED_SIZE)
        )
        .addGroup(layout.createSequentialGroup()
        .addComponent(threeButton, javax.swing.GroupLayout.PREFERRED_SIZE,
        javax.swing.GroupLayout.DEFAULT_SIZE, 
        javax.swing.GroupLayout.PREFERRED_SIZE)
        )
        )
        .addContainerGap(20, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

        .addGroup(layout.createSequentialGroup()
        .addComponent(fourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 
        javax.swing.GroupLayout.DEFAULT_SIZE, 
        javax.swing.GroupLayout.PREFERRED_SIZE)
        )
        .addGroup(layout.createSequentialGroup()
        .addComponent(fiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 
        javax.swing.GroupLayout.DEFAULT_SIZE,
        javax.swing.GroupLayout.PREFERRED_SIZE)
        )
        .addGroup(layout.createSequentialGroup()
        .addComponent(sixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 
        javax.swing.GroupLayout.DEFAULT_SIZE, 
        javax.swing.GroupLayout.PREFERRED_SIZE)
        )
        )
        .addContainerGap(150, Short.MAX_VALUE)) //how wide is the box
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {oneButton});

    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap(50, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oneButton)
                    .addComponent(fourButton)
                    )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(twoButton)                  
                    .addComponent(fiveButton) 
                    )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threeButton)
                    .addComponent(sixButton)
                    )
            .addContainerGap(50, Short.MAX_VALUE) 
            )
    );
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Operator Menu");
       
       
  }
  
  /**
   * This is the method that is called from external functions to display
   * this window.
   * @author Emerson
   */
  public void display() {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
          new OperatorMenu().setVisible(true);
        }
      });
  }


  private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(null, "We will now add a Member",
        "Welcome",
        JOptionPane.INFORMATION_MESSAGE);
    String name = JOptionPane.showInputDialog("Please enter the new member's name",
        "Member Creator");
    if (name == null) {
      JOptionPane.showMessageDialog(null, "Exiting Member Creator", 
          "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    String streetAddress = JOptionPane.showInputDialog(
        "Please enter the new member's street address", "Member Creator");
    if (streetAddress == null) {
      JOptionPane.showMessageDialog(null, "Exiting Member Creator",
          "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    String city = JOptionPane.showInputDialog(
          "Please enter the new member's city","Member Creator");
    if (city == null) {
      JOptionPane.showMessageDialog(null, "Exiting Member Creator", 
          "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    String state = JOptionPane.showInputDialog(
           "Please enter the new member's state","Member Creator");
    if (state == null) {
      JOptionPane.showMessageDialog(null, "Exiting Member Creator",
          "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    String zip = JOptionPane.showInputDialog(
          "Please enter the new member's zip code","Member Creator");
    if (zip == null) {
      JOptionPane.showMessageDialog(null, "Exiting Member Creator", 
          "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    MemberController control = new MemberController();
    JOptionPane.showMessageDialog(null, "New Member Added \n Their number is: " 
        + control.addMember(name, streetAddress, city, state, zip), "Success", 
        JOptionPane.INFORMATION_MESSAGE);
    return;
  }

  private void twoButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String memberNumber = JOptionPane.showInputDialog(
        "Member Finder", "Please enter the Member Number");
    if (memberNumber == null) {
      JOptionPane.showMessageDialog(null,
          "No Member of That Number Exists", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    MemberController controller = new MemberController();
    controller.deleteMember(memberNumber);
    //remove member
  }

  private void threeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String memberNumber = JOptionPane.showInputDialog(
        "Member Finder", "Please enter the Member Number");
    if (memberNumber == null) {
      JOptionPane.showMessageDialog(null,
          "No Member of That Number Exists", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }
    //get member info
    MemberController controller = new MemberController();
    Member member = controller.searchByNum(memberNumber);
    String name = member.getName();
    String streetAddress = member.getStreetAddress();
    String city = member.getCity();
    String state = member.getState();
    String suspendStatus = member.getSuspendStatus();
    String zip = member.getZip();
    String memberNumberFromLookup = member.getNumber();

    //format data
    String memberInfo = "Name: " + name + "\n" 
        + "Street Address: " + streetAddress + "\n" 
        + "Zip Code: " + zip + "\n" 
        + "City: " + city + "\n" 
        + "State: " + state + "\n" 
        + "Suspend Status: " + suspendStatus + "\n" 
        + "Member ID Number: " + memberNumberFromLookup + "\n";

    //display in text panel
    JOptionPane.showMessageDialog(null, memberInfo,
        "Member Information", JOptionPane.INFORMATION_MESSAGE);
    
    //edit member
    //they select an element, and are then given the option to replace it
    JFrame frame = new JFrame("Member Editor");
    String[] editOptions = {"Name: " + name,
        "Street Address: " + streetAddress,"Zip code: " 
        + zip, "City: " + city,"State: " + state }; //Here is where the data goes
    String informationToEdit = (String) JOptionPane.showInputDialog(frame, 
        "Select Element to Edit",
        "Elements",
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        editOptions, 
        editOptions[0]);
    //Temp string is null if they cancel out of the drop down, so we stop this function
    if (informationToEdit == null) { 
      return; 
    }

    //Take in the new information
    if (informationToEdit.contentEquals(editOptions[0])) { //name
      String newInformation = JOptionPane.showInputDialog("Information Editor", 
          "Please enter the new Name");
      if (newInformation == null) {
        return;
      } 
      name = newInformation;
    } else if (informationToEdit.contentEquals(editOptions[1])) { //address
      String newInformation = JOptionPane.showInputDialog(
          "Information Editor", "Please enter the new StreetAddress");
      if (newInformation == null) {
        return;
      }
      streetAddress = newInformation;
    } else if (informationToEdit.contentEquals(editOptions[2]))  { //zip
      String newInformation = JOptionPane.showInputDialog(
          "Information Editor", "Please enter the new Zip Code");
      if (newInformation == null) {
        return;
      }
      zip = newInformation;
    } else if (informationToEdit.contentEquals(editOptions[3])) { //city
      String newInformation = JOptionPane.showInputDialog(
          "Information Editor", "Please enter the new City");
      if (newInformation == null) {
        return;
      }
      city = newInformation;
    } else if (informationToEdit.contentEquals(editOptions[4])) { //state
      String newInformation = JOptionPane.showInputDialog(
          "Information Editor", "Please enter the new State");
      if (newInformation == null) {
        return;
      }
      state = newInformation;
    } //After this if/else block, new information should have updated the requested part

    String updatedMemberInfo = "Name: " + name + "\n" 
        + "Street Address: " + streetAddress + "\n" 
        + "Zip Code: " + zip + "\n" 
        + "City: " + city + "\n" 
        + "State: " + state + "\n" 
        + "Suspend Status: " + suspendStatus + "\n" 
        + "Member ID Number: " + memberNumberFromLookup + "\n";

    //reparse the string and make another text panel, then confirm it
    JOptionPane.showMessageDialog(null, updatedMemberInfo,
        "Updated Information", JOptionPane.INFORMATION_MESSAGE);

    int reply = JOptionPane.showConfirmDialog(null,
            "Confirm those changes?", "Confirm Decision", JOptionPane.YES_NO_OPTION);
    if (reply == 1) { //No 
      return;//exits completely, as otherwise we save the data 
    }
    
    //now save the data to the file
    //do for all, since only one will change
    controller.editMember("NAME",name,memberNumber);
    controller.editMember("ADDRESS",streetAddress,memberNumber);
    controller.editMember("CITY",city,memberNumber);
    controller.editMember("STATE",state,memberNumber);
    controller.editMember("ZIP",zip,memberNumber);

    JOptionPane.showMessageDialog(null, "Information Edited",
        "Success", JOptionPane.INFORMATION_MESSAGE);

    return;
  }

  private void fourButtonActionPerformed(java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(null, "We will now add a Provider",
        "Welcome", JOptionPane.INFORMATION_MESSAGE);
    String name = JOptionPane.showInputDialog(
        "Please enter the new Provider's name", "Provider Creator");
    if (name == null) {
      JOptionPane.showMessageDialog(null,
          "Exiting Provider Creator", "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    String streetAddress = JOptionPane.showInputDialog(
        "Please enter the new Provider's street address", "Provider  Creator");
    if (streetAddress == null) {
      JOptionPane.showMessageDialog(null,
          "Exiting Provider Creator", "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    String city = JOptionPane.showInputDialog(
        "Please enter the new Provider's city", "Provider Creator");
    if (city == null) {
      JOptionPane.showMessageDialog(null, 
          "Exiting Provider Creator", "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    String state = JOptionPane.showInputDialog(
        "Please enter the new Provider's state", "Provider Creator");
    if (state == null) {
      JOptionPane.showMessageDialog(null, 
          "Exiting Provider Creator", "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    String zip = JOptionPane.showInputDialog(
        "Please enter the new Provider's zip code", "Provider Creator");
    if (zip == null) {
      JOptionPane.showMessageDialog(null, 
          "Exiting Provider Creator", "Exit", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    ProviderController control = new ProviderController();
    JOptionPane.showMessageDialog(null, 
        "New Provider Added \n Their number is: " 
        + control.addProvider(name, streetAddress, city, state, zip), "Success",
        JOptionPane.INFORMATION_MESSAGE);
    
    return;
  }

  private void fiveButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String providerNumber = JOptionPane.showInputDialog(
        "Provider Finder", "Please enter the Provider Number");
    if (providerNumber == null) {
      JOptionPane.showMessageDialog(null, 
          "No Member of That Number Exists", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

    ProviderController controller = new ProviderController();
    controller.deleteProvider(providerNumber);
  }

  private void sixButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String providerNumber = JOptionPane.showInputDialog(
        "Provider Finder", "Please enter the Provider Number");
    if (providerNumber == null) {
      return;
    }

    //get provider info
    ProviderController controller = new ProviderController();
    Provider provider = controller.searchByNum(providerNumber);
    if (provider == null) {
      JOptionPane.showMessageDialog(null, 
          "No Provider of That Number Exists", "ERROR", JOptionPane.ERROR_MESSAGE);
      return;
    }

    //Parse data
    String name = provider.getName();
    String streetAddress = provider.getStreetAddress();
    String city = provider.getCity();
    String state = provider.getState();
    String zip = provider.getZip();
    String providerNumberFromLookup = provider.getNumber();

    //format data 
    String providerInfo = "Name: " + name + "\n" 
        + "Street Address: " + streetAddress + "\n" 
        + "Zip Code: " + zip + "\n" 
        + "City: " + city + "\n" 
        + "State: " + state + "\n"
        + "Member ID Number: " + providerNumberFromLookup + "\n";

    //display in text panel
    JOptionPane.showMessageDialog(null, providerInfo,
        "Member Information", JOptionPane.INFORMATION_MESSAGE);
 
    //edit member
    //they select an element, and are then given the option to replace it
    JFrame frame = new JFrame("Provider Editor"); //This sets up the JFRame
    String[] editOptions =
        {"Name: " + name,
        "Street Address: " + streetAddress,
        "Zip code: " + zip, 
        "City: " + city,
        "State: " + state,
        "Member ID Number: " + providerNumberFromLookup}; //Here is where the data goes
    
    String informationToEdit = (String) JOptionPane.showInputDialog(frame, //This Displays it
        "Select Element to Edit",
        "Elements",
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        editOptions, 
        editOptions[0]);
 
    //Temp string is null if they cancel out of the drop down, so we stop this function
    if (informationToEdit == null) {
      return;
    }

    //Take in the new information
    if (informationToEdit.contentEquals(editOptions[0])) { //name
      String newInformation = JOptionPane.showInputDialog(
          "Information Editor", "Please enter the new Name");
      if (newInformation == null) {
        return;
      } 
      name = newInformation;
    } else if (informationToEdit.contentEquals(editOptions[1])) { //address
      String newInformation = JOptionPane.showInputDialog(
          "Information Editor", "Please enter the new StreetAddress");
      if (newInformation == null) {
        return;
      }
      streetAddress = newInformation;
    } else if (informationToEdit.contentEquals(editOptions[2])) { //zip
      String newInformation = JOptionPane.showInputDialog(
          "Information Editor", "Please enter the new Zip Code");
      if (newInformation == null) {
        return;
      }
      zip = newInformation;
    } else if (informationToEdit.contentEquals(editOptions[3])) { //city
      String newInformation = JOptionPane.showInputDialog(
          "Information Editor", "Please enter the new City");
      if (newInformation == null) {
        return;
      }
      city = newInformation;
    } //After this if/else block, new information should have updated the requested part
 
    String updatedProviderInfo = ""
        + "Name: " + name + "\n" 
        + "Street Address: " + streetAddress + "\n" 
        + "Zip Code: " + zip + "\n" 
        + "City: " + city + "\n" 
        + "State: " + state + "\n" 
        + "Provider ID Number: " + providerNumberFromLookup + "\n";
 
    //reparsed the string, now make another text panel, then confirm it
    JOptionPane.showMessageDialog(null, updatedProviderInfo,
        "Updated Information", JOptionPane.INFORMATION_MESSAGE);
 
    int reply = JOptionPane.showConfirmDialog(null, 
        "Confirm those changes?", "Confirm Decision", JOptionPane.YES_NO_OPTION);
    if (reply == 1) { //No 
      return; //exits completely, as otherwise we save the data 
    }

    //save the data to the file
    //do for all, since only one will change
    controller.editProvider("NAME",name,providerNumber);
    controller.editProvider("ADDRESS",streetAddress,providerNumber);
    controller.editProvider("CITY",city,providerNumber);
    controller.editProvider("STATE",state,providerNumber);
    controller.editProvider("ZIP",zip,providerNumber);

    return; 
  }
}


