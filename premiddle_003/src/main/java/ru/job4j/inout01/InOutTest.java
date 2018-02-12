package ru.job4j.inout01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ahh... nothing interestiong. Just testing
 * @author Alex Vasiliev, 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class InOutTest {

   /**
    * @param args - I don't use it yet
    */
   public static void main(final String[] args) {
      Scanner sc = new Scanner(System.in);
      String str1;
      String str2;
      //str1 = sc.nextLine();
      //str2 = sc.nextLine();

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      char ch = '1';
       do {
          try {
             ch = (char) br.read();
          } catch (IOException e) {
             e.printStackTrace();
          }
          System.out.println(ch);
      } while (ch != 'q');
   }
}
