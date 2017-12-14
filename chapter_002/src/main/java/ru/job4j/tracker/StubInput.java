package ru.job4j.tracker;

//import ru.job4j.models.Item;
//import ru.job4j.models.Task;
// import ru.job4j.models.Tracker;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class StubInput implements Input {
   /**
    *
    */
   private String[] ansrs;
   private int position = 0;

   public StubInput(String[] answers) {
      this.ansrs = answers;
   }

   @Override
   public String ask(String quastion) {
      return ansrs[position++];
   }
   
}