package ru.job4j.tracker;

//import ru.job4j.models.item;
//import ru.job4j.models.Task0;
// import ru.job4j.models.Tracker;

import java.util.List;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class StubInput implements Input {
   /**
    * Класс для симуляции действий пользователя.
    */
   private String[] anwrs;
   private int position = 0;

   public StubInput(String[] answers) {
      this.anwrs = answers;
   }

   @Override
   public String ask(String quastion) {
      return anwrs[position++];
   }

   @Override
   public int ask(String question,  List<Integer> range) {
      int key = Integer.valueOf(this.ask(question));
      boolean exist = false;

      return -1;
   }
   
}