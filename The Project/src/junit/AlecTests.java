package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import services.ServiceController;
import services.ServiceRecord;

class AlecTests {

      ServiceRecord someRecord; 
      
      @BeforeEach
      void setUp() throws Exception {
        
      }

      @Test
      void testSanity() {
        
        ServiceRecord myRecord = new ServiceRecord("01-01-19", "01-02-19", "3:20PM", 
            "rory", "1234", "4321", "1181", "26.54", "no");
        ServiceController myService = new ServiceController();
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          myService.addServiceRecord(myRecord); 
        }); 
      }


      @Test 
      void testFailureWriteRecordToDisk() {
        
        Assertions.assertThrows(IllegalArgumentException.class,  () -> {
          ServiceRecord myRecord = new ServiceRecord("01-01-19", "01-02-19", "3:20PM", "rory", "1234", 
              "4321", "1181", "26.54", "no");
          ServiceController myService = new ServiceController();
          myService.writeRecordToDisk(myRecord);
        }); 
      }

      
      @Test 
      void testSuccessaddServiceRecord() {
        ServiceRecord myRecord = new ServiceRecord("01-02-19", "01-02-19", "3:20PM", "rory", "1234", 
            "4321", "1181", "26.54", "no");
        ServiceController myService = new ServiceController();
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          myService.addServiceRecord(myRecord); 
          
        }); 
        
        
        
      }
      
      
      @Test  // failure test // 
      void testBadArgument() {
        ServiceController myService = new ServiceController(); 
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          myService.getRecordsByProvider("1");  
        }); 
        
      }

    }
