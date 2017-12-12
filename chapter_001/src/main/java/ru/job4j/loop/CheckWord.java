package ru.job4j.loop;

import sun.security.util.Length;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    10.12.2017
 * @version  1.0.0
 */

public class CheckWord {
   /**
    * Метод проверяет - включает ли слово-1, часть слова-2.
    */
   public boolean containsWithindexOf(String origin, String sub) {
      boolean subExist = false;
      //return 1;
      int x = origin.indexOf(sub);
      if (x >= 0) {
         subExist = true;
      }
      return subExist;
   }


   public boolean contains(String origin, String sub) {
      // Сначала преобразуем их в массивы
      int lngth  = origin.length();
      char[] ch = origin.toCharArray(); //new char[lngth];
      //for (int i = 0; i < lngth; i++) {         ch[i] = origin.charAt(i);      }
      //
      int lngthSub  = sub.length();
      char[] chSub = sub.toCharArray();//new char[lngthSub];
      //for (int i = 0; i < lngthSub; i++) {         chSub[i] = sub.charAt(i);      }
      // число совпавших букв:
      int concidNum = 0;
      boolean ifExist = false;

      // делаем два цикла. В пермов проходим все буквы до буквы (lenght - LengthSub + 1)
      for (int n = 0; n < (lngth - lngthSub + 1); n++) {
         // во втором проходм все буквы Sub
         for (int m = 0; m < lngthSub; m++) {
            if (ch[n + m] != chSub[m]) {
               concidNum = 0;
            } else {
               concidNum++;
               if (concidNum == lngthSub) {
                  ifExist = true;
                  break;
               }
            }
            // нет смысла продолжать проверки, если найдено совпадение
            if (ifExist) {
               break;
            }
         }
         // нет смысла продолжать проверки, если найдено совпадение
         if (ifExist) {
            break;
         }
      }
      return ifExist;
   }
   /*
   public void main(String[] arg) {
      private String origin = "Слон любит траву";
      private String sub = " люб";

      // Сначала преобразуем их в массивы
      int lngth  = origin.length();
      char[] ch = new char[lngth];
      for (int i = 0; i < lngth; i++) {
         ch[i] = origin.charAt(i);
      }
      //
      int lngthSub  = sub.length();
      char[] chSub = new char[lngthSub];
      for (int i = 0; i < lngthSub; i++) {
         chSub[i] = sub.charAt(i);
      }
      int concidNum = 0;
      boolean ifExist = false;

      // делаем два цикла. В пермов проходим все буквы до буквы (lenght - LengthSub + 1)
      for (int n = 0; n < (lngth - lngthSub + 1); n++) {
         // во втором проходм все буквы Sub
         for (int m = 0; m < lngthSub; m++) {
            if (ch[n + m] != chSub[m]) {
               concidNum = 0;
            } else {
               concidNum++;
               System.out.println("Boo");
               if (concidNum == lngthSub) {
                  ifExist = true;
                  break;
               }
            }
            // нет смысла продолжать проверки, если найдено совпадение
            if (ifExist) {
               break;
            }
         }
         // нет смысла продолжать проверки, если найдено совпадение
         if (ifExist) {
            break;
         }
      }
   } */
}