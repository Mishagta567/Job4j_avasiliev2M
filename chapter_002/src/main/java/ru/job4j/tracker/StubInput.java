package ru.job4j.tracker;

//import ru.job4j.models.Vitem;
//import ru.job4j.models.Vtask;
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
   private String[] anwrs;
   private int position = 0;

   public StubInput(String[] answers) {
      this.anwrs = answers;
   }

   @Override
   public String ask(String quastion) {
      return anwrs[position++];
   }
   
}