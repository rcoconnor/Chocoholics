package alecservicecodes; 


 
public class Service {
  private String serviceCode;
  private String serviceName;
  private String serviceFee;
  
  /**
   * The constructor takes 3 inputs and assigns all instance variables with them.
   * Will throw an exception if any parameters are invalid
   * 
   * @param code The service code, with no more or less than 6 digits
   * @param fee  The service fee, cannot be zero or less
   * @param name The service name
   * @throws IllegalArgumentException Exception thrown if either the code or fee are invalid
   */
  public Service(String code, String fee, String name) throws IllegalArgumentException {
    
    if (code.length() != 6) {
      throw new IllegalArgumentException("Service() constructor: invalid serviceCode"); 
    } else if (Integer.parseInt(fee) < 0) {
      throw new IllegalArgumentException("Service() constructor: invalid fee"); 
    } else {
    
      serviceCode = code;
      serviceName = name;
      serviceFee = fee;
    
    }
  }
  
  /*ACCESSORS*/
  public String getCode() {
    return serviceCode;
  }
  
  public String getFee() {
    return serviceFee;
  }
  
  public String getName() {
    return serviceName;
  }
    
  /*MUTATORS*/
  /**
   * This method takes a code and verifies if it is valid. 
   * If it is, it changes serviceCode to the code.
   * 
   * @param code The service code to be checked and changed to
   * @throws IllegalArgumentException Thrown if the code is invalid
   */
  public void setCode(String code) throws IllegalArgumentException {
    //serviceCode = code;
    if (code.length() != 6) {
      throw new IllegalArgumentException("Service.setCode: invalid service code"); 
    } else {
      serviceCode = code; 
    }
  }
  
  /**
   * This method takes a fee and verifies if it is valid. 
   * If it is, it changes serviceFee to the fee.
   * 
   * @param fee The service fee to be checked and changed to
   * @throws IllegalArgumentException Thrown if the fee is invalid
   */
  public void setFee(String fee) throws IllegalArgumentException {
    if (Integer.parseInt(fee) < 0) {
      throw new IllegalArgumentException("service.setFee: invalid service fee");  
    } else {
      serviceFee = fee;
    }
  }
  
  
  public void setName(String name) {
    serviceName = name;
  }
  
  /*MISC*/
  /**
   * Compiles the information in the service into one formatted string.
   * 
   * @return Returns the string
   */
  public String print() {
    return "Name: " + serviceName
            + ". Number: " + serviceCode 
            + ". Fee: " + serviceFee + ".";
  }
}