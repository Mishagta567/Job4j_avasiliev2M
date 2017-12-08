package ru.job4j.loop;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    08.12.2017
 * @version  1.0.0
 */

public class Board {

   /**
    * Нарисуем псевдо доску
    *
    */
   public String paint(int width, int height) {
      StringBuilder screen = new StringBuilder();
      String ln = System.lineSeparator();
      for (int hg = 1;  hg <= height; hg++) {
         for (int wd = 1; wd <= width; wd++ ) {
            // условие проверки, что писать пробел или X
            // на нечетной по высоте ставим Х для нечетных wd  ,
            // на   четных по высоте ставим Х для   четных wd
            if ((wd % 2 == 1) && (hg % 2 == 1) ||
                (wd % 2 == 0) && (hg % 2 == 0)  ) {
               screen.append("X");
            } else {
               screen.append(" ");
            }
            //System.out.println(" wd = " + wd);
         }
         // добавляем перевод на новую строку.
         //System.out.println(" __hg = " + hg);
         screen.append(ln);
      }
      return screen.toString();
   }

}