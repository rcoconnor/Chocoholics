package elleuser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**This class performs actions on provider objects and manages the provider directory.
 * 
 * @author Ellen DiSilverio 11770725
 *
 */
public class ProviderController {
  //attributes//
  ArrayList<Provider> providerDirectory;
  
  //Constructor//
  public ProviderController() {
    //this opens the file where the directory information is/will be stored
    String home = System.getProperty("user.dir");
    String path = home + File.separator + "src" + File.separator + "elleuser" + File.separator 
        + "Data" + File.separator + "providerDirectory.txt";
    File file = new File(path);
    this.providerDirectory = new ArrayList<Provider>();

    try {
      boolean check = file.createNewFile();
      if (check == false) {
        //if the file already exists, the directory is initialized using info from the file
        Scanner sc = new Scanner(file); 
        String input;
        //providers in directory are read in the order:
        //name, address, city, state, zip, number

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

          Provider provider = new Provider(name, address,  city, state, zip, num);
          this.providerDirectory.add(provider);
        } 
        sc.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  //methods//
  public Provider searchByNum(String number) {
    //finds a provider in the directory based off a passed ID number
    for (int i = 0;i < this.providerDirectory.size();i++) {
      if (this.providerDirectory.get(i).getNumber().equals(number)) {
        //System.out.println(this.providerDirectory.get(i).getNumber());
        return this.providerDirectory.get(i);
      }
    }
    return null;
  }

  public String getNameByNumber(String num) {
    //returns name of member with the passed ID number
    Provider provider = searchByNum(num);
    return provider.getName();
  }

  public String addProvider(String name, String streetAddress, String city, String state, String zip) {
    String num = this.generateID();//generates random 9 digit ID number
    Provider provider = new Provider(name, streetAddress,city, state, zip,num);
    this.providerDirectory.add(provider);
    this.writeToFile();//updates file where directory information is written
    JOptionPane.showMessageDialog(null, "New Provider Added \n Their number is: " + num, "Success",
            JOptionPane.INFORMATION_MESSAGE);
    return num;
  }

  public void deleteProvider(String num) {
    Provider provider = this.searchByNum(num);//gets provider with the passed ID number
    this.providerDirectory.remove(provider);
    this.writeToFile();//updates file where directory information is written
  }

  public void editProvider(String type, String info,String num) {
    Provider provider = this.searchByNum(num);//gets the right provider to edit

    if (provider == null) {
      System.out.println("INVALID NUMBER");
      return;
    }

    switch (type) {
      case "NAME":
        provider.setName(info);
        //System.out.println("Name is now:" + info);
        this.writeToFile();
        break;

      case "ADDRESS":
        provider.setStreetAddress(info);
        //System.out.println("Address is now:" + info);
        this.writeToFile();
        break;

      case "CITY":
        provider.setCity(info);
        //System.out.println("City is now:" + info);
        this.writeToFile();
        break;

      case "STATE":
        provider.setState(info);
        //System.out.println("State is now:" + info);
        this.writeToFile();
        break;

      case "ZIP":
        provider.setZip(info);
        //System.out.println("Zip is now:" + info);
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
    //returns a provider's info in a string
    Provider provider = this.searchByNum(number);
    if (provider == null) {
      return null;
    }

    String info = "";
    info += provider.getName();
    info += "@@";
    info += provider.getStreetAddress();
    info += "@@";
    info += provider.getCity();
    info += "@@";
    info += provider.getState();
    info += "@@";
    info += provider.getNumber();
    info += "@@";
    info += provider.getZip();
    info += "@@";
    return info;
  }

  public boolean validateProvider(String number) {
    Provider provider = searchByNum(number);
    if (provider == null) {
      return false;
    } else {
      return true;
    }
  }

  public String generateID() {
    //creates a random unique 9 digit id number
    Random random = new Random();
    String n = String.format("%09d", random.nextInt(1000000000));

    for (int i = 0;i < this.providerDirectory.size();i++) {
      if (this.providerDirectory.get(i).getNumber().equals(n)) {
        n = String.format("%09d", random.nextInt(1000000000));
        i = 0;
      }
    }
    return n;
  }

  public void writeToFile() {
    //writes the directory information to a text file
    String home = System.getProperty("user.dir");
    String path = home + File.separator + "src" + File.separator + "elleuser" 
               + File.separator + "Data" + File.separator + "providerDirectory.txt";
    File file = new File(path);
    FileWriter fw;
    try {
      fw = new FileWriter(file);
      BufferedWriter bw = new BufferedWriter(fw);
      for (int i = 0;i < this.providerDirectory.size();i++) {
        bw.write(this.providerDirectory.get(i).getName() + "\n");
        bw.write(this.providerDirectory.get(i).getStreetAddress() + "\n");
        bw.write(this.providerDirectory.get(i).getCity() + "\n");
        bw.write(this.providerDirectory.get(i).getState() + "\n");
        bw.write(this.providerDirectory.get(i).getZip() + "\n");
        bw.write(this.providerDirectory.get(i).getNumber() + "\n");
      }
      bw.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public ArrayList<String> getAllProviderNumbers() {
    //returns a list of all the provider ID numbers
    ArrayList<String> numbers = new ArrayList<String>();
    for (int i = 0;i < this.providerDirectory.size();i++) {
      numbers.add(this.providerDirectory.get(i).getNumber());
    }
    return numbers;
  }
}
