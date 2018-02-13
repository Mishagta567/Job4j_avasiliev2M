package ru.job4j.inout01;


import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.Charset;


/**
 * ahh... nothing interestiong. Just testing
 * @author Alex Vasiliev, 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class InputOutput {

   /**
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
    * @param in - input Stream int
    * @param out - sure thing outPutStream
    * @param abuse - all abuse words.
    */
   void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
      byte[] buff = new byte[1024];
      //BufferedInputStream - good for speed
      String stringFromBuff = "";
      String uncheckedString = "";
      String checkedString = "";
      int count = 0;
      int spacePosition = 0;

      int i;
      while ((i = in.read()) != -1) {
         //out.write(i);
         //baos.flush();
         stringFromBuff = stringFromBuff + (char) i;
         count++;

         if (count > 1024) {
            // lets move back to first ' ' char from back
            if (!uncheckedString.equals("")) {
               checkedString = uncheckedString + checkedString;
               uncheckedString = "";
            }

            spacePosition = stringFromBuff.lastIndexOf(' ');
            if (spacePosition > 0) {
               if (uncheckedString.equals(null)) {
                  checkedString = stringFromBuff.substring(0, spacePosition);
                  uncheckedString = stringFromBuff.substring(spacePosition);
               } else {
                  checkedString = uncheckedString + stringFromBuff.substring(0, spacePosition);
                  uncheckedString = stringFromBuff.substring(spacePosition);
               }
            }
            count = 0;
            checkedString = dropAbuse(checkedString, abuse);
            out.write(checkedString.getBytes());
            checkedString = "";
         }
      }
      if (!stringFromBuff.equals("")) {
         if (!uncheckedString.equals("")) {
            stringFromBuff = uncheckedString + stringFromBuff;
         }
         checkedString = dropAbuse(stringFromBuff, abuse);
         out.write(checkedString.getBytes());
         checkedString = "";
      }

   }

   private String dropAbuse(String checkString, String[] abuse) {
      String resultString = checkString;
      int abusePosition = 0;
      // Now, lets check for Abouse words
      for (String abs : abuse) {
         while ((abusePosition = resultString.indexOf(abs)) > 0) {
            // and remove them if find any
            resultString = resultString.substring(0, abusePosition)
                    + resultString.substring(abusePosition + abs.length());
         }
      }
      return resultString;
   }



   /**
    * @param args - I don't use it yet
    */
   public static void main(String[] args) throws IOException {

      System.out.print("Hello there");

   }

   //Reader reader = new InputStreamReader(in, "UTF-8");
   //System.out.println(out.toString());
   //ByteArrayInputStream bais = new ByteArrayInputStream(startString.getBytes("UTF-8"));
   //ByteArrayOutputStream baos = new ByteArrayOutputStream();
   //int i;
   //String myString = "";
   //while ( ( i = in.read() ) != -1  ){
   //   //baos.write(i);
   //   //baos.flush();
   //   myString = myString + (char) i;
   //}

   // 12-3-29:55 writeUTF,  38:53 - dataInput.readUTF
   // Reader reader = new InputStreamReader(in, "windows-1251")  13-1-14:53
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
   // min 18, 20
   // Exeption: 1-4-26.18
}
