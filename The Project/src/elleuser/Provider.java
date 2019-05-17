package elleuser; 

/**This class represents ChocAn Providers.
 * 
 * @author Ellen DiSilverio 11770725
 *
 */
public class Provider extends User {

  //Constructor

  /**This constructs Provider objects.
   * 
   * @param name Provider's name
   * @param address Provider's Address
   * @param city Provider's City
   * @param state Provider's State
   * @param zip Provider's Zipcode
   * @param num Provider's ID number
   */
  public Provider(String name, String address, String city, String state, String zip,String num) {
    setName(name);
    setStreetAddress(address);
    setCity(city);
    setState(state);
    setNumber(num);
    setZip(zip);
  }
  
  @Override
  public String toString() {
    String s = name + "\n" + streetAddress + "\n" + city 
            + "\n" + state + "\n" + zip + "\n" + number + "\n";
    return s;
  }
}
