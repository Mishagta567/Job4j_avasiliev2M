package ru.job4j.collections;//package ru.job4j.collections;

import java.util.*;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */

public class ConvertArray {

   //List<Integer> oneDlist = Arrays.asList(1, 2, 3, 4, 5, 6);
   //List<Integer[][]> twoDlist = new List<Integer[][]>;

   int[]   oneDlist = {1, 2, 3, 4, 5, 6};
   int[][] twoDlist = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};


   public List<Integer> toOneDemList (int[][] list) {
   //public void toList (int[][] twoDlist) {
      //for (int itm : twoDlist)
      int lngth = list.length;

      //  Это я не понял. Почему:      new "ArrayList"<Integer>();    ?
      List<Integer> rslt = new ArrayList<Integer>();
      int indx = 0;
      // loop для квадратной матрицы не сложный
      // Но что делать если у нас будут другие размерности?
      // Или какие-то ячейки не заполнены? Как проверять что они заполнены?
      for (int firstDem = 0; firstDem < lngth; firstDem++) {
         for (int secondDem = 0; secondDem < lngth; secondDem++) {
            rslt.add(list[firstDem][secondDem]);
         }
      }
      //System.out.println(lngth);
      return rslt;
   }

   public int[][] toTwoDemList (int[] list) {

      int lngth = list.length;

      // Здесь нужно инициализировать 2-ух мерную коллекцию, но я не понял как. Нужно поправить.
      int[][] rslt = new int[lngth][lngth];
      int indx = 0;

      // заполним квадратную матрицу.
      // Причем, в случае если мы вышли за длину массива - вносим 0.
      for (int firstDem = 0; firstDem < lngth; firstDem++) {
         for (int secondDem = 0; secondDem < lngth; secondDem++) {
            rslt[firstDem][secondDem] = (indx < lngth ? list[indx++] : 0);
         }
      }
      //System.out.println(lngth);
      return rslt;
   }

/***
   public static void main(String[] args) {
         System.out.println("Yo");
      }     //  */
}