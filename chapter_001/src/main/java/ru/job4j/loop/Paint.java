package ru.job4j.loop;

import javafx.stage.Screen;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    08.12.2017
 * @version  1.0.0
 */

public class Paint {
   /**
    * Метод должен вычислять сумму четныx чисел в диапазоне от tracker до finish;    *
    */
   public String piramid(int h) {   // 3
      // Рисуем
      StringBuilder screen = new StringBuilder();
      String ln = System.lineSeparator();
      // Для упрощения цикла, введем переменную: Cx
      int wth =  (h - 1) * 2 + 1;
      for (int lH = 1; lH <= h; lH++) {
         for (int strL = 1; strL <= wth; strL++) {
            if ((strL < (h + 1 - lH)) || (strL > (h + lH - 1))) {
               screen.append(" ");
            } else {
               screen.append("^");
            }
         }
         screen.append(ln);
      }
      return screen.toString();
   }

}