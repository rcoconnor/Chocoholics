package elleuser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**This Class performs actions on member objects and manages the member directory.
 * 
 * @author Ellen DiSilverio 11770725
 *
 */
public class MemberController {
  //attributes//
  ArrayList<Member> memberDirectory;

  //Constructor//
  public MemberController() {
    //this opens the file where the directory information is/will be stored
    String home = System.getProperty("user.dir");
    String path = home + File.separator + "src" + File.separator + "elleuser" + File.separator
        + "Data" + File.separator + "memberDirectory.txt";
    File file = new File(path); 
    this.memberDirectory = new ArrayList<Member>();

    try {
      boolean check = file.createNewFile();
      if (check == false) {
        //if the file already exists, the directory is initialized using info from the file
        Scanner sc = new Scanner(file); 
        String input;
        //members in directory are read in the order:
        //name, address, city, state, zip, number, status

        while ((sc.hasNextLine())) {
          input = sc.nextLine();
          String name = input;
          input = sc.nextLine();
          String address = input;
          input = sc.nextLine();
          String city = input;
          input = sc.nextLine();
          String state = input;
          input = sc.nextLine();
          String zip = input;
          input = sc.nextLine();
          String num = input;
          input = sc.nextLine();
          String status = input;

          Member member = new Member(name, address,  city,  state, zip, num, status);
          this.memberDirectory.add(member);
        }
        sc.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //methods//
  public Member searchByNum(String number) {
    //uses passed number to find corresponding member
    for (int i = 0;i < this.memberDirectory.size();i++) {
      if (this.memberDirectory.get(i).getNumber().equals(number)) {
        return this.memberDirectory.get(i);
      }
    }
    return null;
  }

  public String getNameByNum(String num) {
    //returns the name of a member with the passed number
    Member member = searchByNum(num);
    if(member == null) {
    	System.out.println("NOT FOUND");
    }
    return member.getName();
  }

  public String addMember(String name, String streetAddress, String city, String state, String zip) {
    String num = this.generateID(); //generates random unique 9 digit number
    Member member = new Member(name, streetAddress,city, state, zip,num,"0");

    this.memberDirectory.add(member);
    writeToFile(); //updates file where member directory info is stored
    return num;
  }

  public void deleteMember(String num) {
    Member member = this.searchByNum(num);
    this.memberDirectory.remove(member);
    this.writeToFile(); //updates file where member directory info is stored
  }

  public void editMember(String type, String info,String num) {
    Member member = searchByNum(num);//finds member to be edited based on their number
    
    if (member == null) {
      System.out.println("INVALID NUMBER");
      return;
    }

    switch (type) {
      case "NAME":
        member.setName(info);
        this.writeToFile();
        break;

      case "ADDRESS":
        member.setStreetAddress(info);
        this.writeToFile();
        break;

      case "CITY":
        member.setCity(info);
        this.writeToFile();
        break;

      case "STATE":
        member.setState(info);
        this.writeToFile();
        break;

      case "ZIP":
        member.setZip(info);
        this.writeToFile();
        break;

      case "CANCEL":
        return;

      default:
        System.out.println("Invalid Input");
        break;
    }
  }

  public String getInfo(String number) {
    //returns a member's information in the form of a string
    Member member = searchByNum(number);
    if (member == null) {
      return null;
    }
    String info = "";
    info += member.getName();
    info += "@@";
    info += member.getStreetAddress();
    info += "@@";
    info += member.getCity();
    info += "@@";
    info += member.getState();
    info += "@@";
    info += member.getNumber();
    info += "@@";
    info += member.getZip();
    info += "@@";
    info += member.getSuspendStatus();
    info += "@@";
    return info;
  }

  public boolean validateMember(String number) {
    Member member = searchByNum(number);
    if (member == null) {
      return false;
    } else {
      return true;
    }
  }

  public String generateID() {
    //generates unique random 9 digit number
    Random random = new Random();
    String n = String.format("%09d", random.nextInt(1000000000));

    for (int i = 0;i < this.memberDirectory.size();i++) {
      if (this.memberDirectory.get(i).getNumber().equals(n)) {
        n = String.format("%09d", random.nextInt(1000000000));
        i = 0;
      }
    }
    return n;
  }

  public void writeToFile() {
    //writes the information stored in the member directory ArrayList into a file
    String home = System.getProperty("user.dir");
    String path = home + File.separator + "src" + File.separator 
                + "elleuser" + File.separator + "Data" + File.separator + "memberDirectory.txt";
    File file = new File(path);
    FileWriter fw;
    try {
      fw = new FileWriter(file);
      BufferedWriter bw = new BufferedWriter(fw);
      for (int i = 0;i < this.memberDirectory.size();i++) {
        bw.write(this.memberDirectory.get(i).getName() + "\n");
        bw.write(this.memberDirectory.get(i).getStreetAddress() + "\n");
        bw.write(this.memberDirectory.get(i).getCity() + "\n");
        bw.write(this.memberDirectory.get(i).getState() + "\n");
        bw.write(this.memberDirectory.get(i).getZip() + "\n");
        bw.write(this.memberDirectory.get(i).getNumber() + "\n");
        bw.write(this.memberDirectory.get(i).getSuspendStatus() + "\n");
      }
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<String> getAllMemberNumbers() {
    //returns a list of all member ID numbers
    ArrayList<String> numbers = new ArrayList<String>();
    for (int i = 0;i < this.memberDirectory.size();i++) {
      numbers.add(this.memberDirectory.get(i).getNumber());
    }
    return numbers;
  }
}