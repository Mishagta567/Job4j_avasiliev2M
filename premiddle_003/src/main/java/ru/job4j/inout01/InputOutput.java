package ru.job4j.inout01;


import java.io.*;


/**
 * ahh... nothing interestiong. Just testing
 * @author Alex Vasiliev, 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class InputOutput {

   /**
    *
    * @param in - input Stream int
    */
   public boolean checkNumberFromStream(InputStream in) {
      boolean result = false;
      int oneByte = 0;
      String inputString = "";
      int inputNumber = -1;

      while (true) {
         try {
            oneByte = in.read();
         } catch (IOException e) {
            e.printStackTrace();
         }
         if (oneByte != -1) {
            inputString = inputString + (char) oneByte;
         } else {
            break;
         }
      }

      try {
         inputNumber = new Integer(inputString);
      } catch (NumberFormatException e) {
         System.err.println("Wrong input format!" + e);
      }

      if (inputNumber % 2 == 0) {
         result = true;
      }

      return result;
   }


   /**
    * @param args - I don't use it yet
    */
   public static void main(final String[] args) {
      InputOutput iot = new InputOutput();

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      InputStreamReader in = new InputStreamReader(System.in);
      int number = 0;

      // ByteArrayInputStream(new byte[] {49, 50, 53, 54} - 1256
      System.out.println(iot.checkNumberFromStream(new ByteArrayInputStream(new byte[] {49, 50, 53, 54})));
   }

   //Scanner sc = new Scanner(System.in);
   //String str1;
   //String str2;
   //str1 = sc.nextLine();
   //str2 = sc.nextLine();
   //
   //for (int indx = 0; indx < 100; indx++) {
   //   System.out.println(indx + " - " + (char) indx);
   //}
   // byte(-127) -> int(129)
   // byte(-3) -> int(253)
   // byte(-2) -> int(254)
   // byte(-1) -> int(255)
   // byte(0)  -> int(0)
   // byte(1)  -> int(1)
   // byte(2)  -> int(2)
   // byte(3)  -> int(3)
   // byte(125) -> int(125)
   // byte(126) -> int(126)
   // byte(127) -> int(127)
}
