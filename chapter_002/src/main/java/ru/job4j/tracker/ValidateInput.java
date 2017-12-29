package ru.job4j.tracker;

//import ru.job4j.models.item;
//import ru.job4j.models.Task0;
// import ru.job4j.models.Tracker0;

//import java.util.Scanner;

import java.util.List;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class ValidateInput implements Input {
   /**
    *    Реализация контроля ввода от пользователя.
    */
   private final Input input;

   public ValidateInput(final  Input input) {
      this.input = input;
   }

   @Override
   public String ask(String question) {
      return this.input.ask(question);
   }

   @Override
   public int ask(String question,  List<Integer> range) {
      boolean invalid = true;
      int value = -1;
      do {
         try {
            value = this.input.ask(question, range);
            invalid = false;
         } catch (MenuOutException moe) {
            //moe.printStackTrace();
            System.out.println("Enter number from menu:");
         } catch (NumberFormatException nfe) {
            System.out.print("Please enter validate number.");
         }
      } while (invalid);
      return value;
   }
}