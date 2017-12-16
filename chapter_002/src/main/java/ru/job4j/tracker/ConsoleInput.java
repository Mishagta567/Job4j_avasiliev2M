package ru.job4j.tracker;

//import ru.job4j.models.Vitem;
//import ru.job4j.models.Vtask;
// import ru.job4j.models.Tracker;

import java.util.Scanner;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class ConsoleInput implements Input {
   /**
    *
    */
   private Scanner scanner = new Scanner(System.in);

   @Override
   public String ask(String question) {
      System.out.println(question);
      return scanner.nextLine();
      //return "6";
   }
   
}