package ru.job4j.tracker;

//import ru.job4j.models.item;
//import ru.job4j.models.Task0;
// import ru.job4j.models.Tracker0;

//import java.util.Scanner;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class ValidateInput extends ConsoleInput {
   /**
    *    Реализация контроля ввода от пользователя.
    */
   @Override
   public int ask (String question, int[] range) {
      boolean invalid = true;
      int value = -1;
      do {
         try {
            value = super.ask(question, range);
            invalid = false;
         } catch (MenuOutException moe) {
            //moe.printStackTrace();
            System.out.println("Enter number from menu:");
         } catch (NumberFormatException nfe) {
            System.out.println("Not letters. Only number from 1 to 7: ");
         }
      } while (invalid);
      return value;
   }
}