package elleuser;

/**This class defines Member objects.
 * 
 * @author Ellen DiSilverio 11770725
 *
 */
public class Member extends User {
  //Member specific attributes
  String suspendStatus;

  //Constructor
  /**This Constructs Member Objects.
   * 
   * @param name The Member's Name
   * @param address The Member's Address
   * @param city The Member's City
   * @param state The Member's State
   * @param zip The Member's Zipcode
   * @param num The Member's ID number
   * @param status The Member's suspended status: 0 is active, 1 is suspended
   */
  public Member(String name, String address, String city, String state, String zip, 
          String num, String status) {
    setName(name);
    setStreetAddress(address);
    setCity(city);
    setState(state);
    setNumber(num);
    setZip(zip);
    setSuspendStatus(status);
  }
  //Getter and Setter
  
  /**Accesses the suspend status of the member.
   * 
   * @return the suspend status of the member. 0 is active, 1 is suspended, 
   */
  public String getSuspendStatus() {
    return this.suspendStatus;
  }
  
  /**This sets the member's suspension status.
   * 
   * @param suspendStatus is 0 or 1, representing either active or suspended.
   */
  public void setSuspendStatus(String suspendStatus) {
    this.suspendStatus = suspendStatus;
  }

  @Override
  /**formats a member object into a string clearly communicating its attributes.
   * @return the formatted string
   */
  public String toString() {
    String s = name + "\n" + streetAddress + "\n" + city + "\n" + state + "\n" 
        + zip + "\n" + number + "\n" + suspendStatus + "\n";
    return s;
  }
}