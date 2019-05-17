package elleuser;

/** This class represents an abstract user object that extends into member and provider.
 * 
 * @author Ellen DiSilverio 11770725
 *
 */
public class User {

  //attributes//
  String name;
  String streetAddress;
  String city;
  String state;
  String zip;
  String number;

  //getters and setters//
  public String getName() {
    return this.name;
  }

  public String getStreetAddress() {
    return this.streetAddress;
  }

  public String getCity() {
    return this.city;
  }

  public String getState() {
    return this.state;
  }

  public String getZip()  {
    return this.zip;
  }

  public String getNumber() {
    return this.number;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStreetAddress(String address) {
    this.streetAddress = address;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public void setNumber(String num) {
    this.number = num;
  }
}