package ru.job4j.collections;

import java.util.*;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  2.0.0
 */

public class ConvertArray {

   int[] oneDArr = {1, 2, 3, 4, 5, 6};
   int[][] twoDArr = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};

   List<Integer> oneDlist = Arrays.asList(1, 2, 3, 4, 5, 6);  // чисто для примера
   // Чуть навароченнее с определением 2-ух мерного листа
   List<List> twoDlist = new ArrayList<List>();

   // А это видимо более правильная: обработка коллекций:
   public List<Integer> toOneDemList2(List<List> list) {
      //int lngth = list.length;
      int lngth = 0;
      //  Это я не понял. Почему:      new "ArrayList"<Integer>();    ?
      List<Integer> rslt = new ArrayList<>();
      for (List lst : list) {
         //По идее нужно было сделать loop c    rslt.add(lst.get(indx)); Но почему-то не сработало. А как влезать?
         rslt.addAll(lst);
      }
      //System.out.println(lngth);
      return rslt;
   }

   public List<List> toTwoDemList2(List<Integer> list) {
      int lngth = list.size();
      int inputCollindex = 0;
      int collLength = (int) Math.ceil(Math.sqrt(lngth));   // округленный вверх корень из длины - размер матрицы.
      List<Integer> temp = new ArrayList<>();

      List<List> rslt = new ArrayList<List>();
      for (int indLength = 0; indLength < collLength; indLength++) {
         temp.clear();
         for (int indHight = 0; indHight < collLength; indHight++) {
            if (inputCollindex < lngth) {
               temp.add(indHight, list.get(inputCollindex++));  // если есть элементы массива - добавляем их
            } else {
               temp.add(indHight, 0); // если нет - добавляем 0
            }
         }
         rslt.add(temp);
      }
      return rslt;
   }

   /*** Обычная реализация, которую теперь можно закоментировать.
   public List<Integer> toOneDemList(int[][] list) {
      //public void toList (int[][] twoDArr) {
      //for (int itm : twoDArr)
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

   public int[][] toTwoDemList(int[] list) {
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
   }  // */


   public static void main(String[] args) {
         System.out.println(Math.ceil(3.1));
      }
}