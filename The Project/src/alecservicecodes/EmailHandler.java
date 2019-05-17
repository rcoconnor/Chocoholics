package alecservicecodes; 

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
public class EmailHandler {
  /** Takes parameters of a message and saves it in a txt file.
   * 
   * @param contents Contents of the message
   * @param title    Title of the message
   * @param reciever Recipient of the message
   * @return boolean Checks if the message has been successfully saved
   */

  public static boolean saveEmailTxt(String contents, String title, String reciever) {
    try {
      String h2 = System.getProperty("user.dir");
      String p2 = h2 + File.separator 
              + "src" + File.separator
              + "alecservicecodes" + File.separator 
              + title + ".txt";
      File f = new File(p2);
      f.createNewFile();
      FileWriter w = new FileWriter(f);

      w.write("Title: " + title);
      w.write("Recipient: " + reciever);
      w.write("Contents: " + contents);
        
      w.flush();
      w.close();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}