package ru.job4j.collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */

public class ListCompare implements Comparator<List<Integer>> {
   private List<Integer> left;
   private List<Integer> right;

   public ListCompare(List<Integer> left, List<Integer> right) {
      this.left = left;
      this.right = right;
   }

   public List<Integer> getLeft() {
      return left;
   }
   public List<Integer> getRight() {
      return right;
   }

   @Override
   public int compare(List<Integer> left, List<Integer> right) {
      int rslt = 0;
      int leftSize = left.size();
      int rightSize = right.size();
      if (leftSize != rightSize) {
         rslt = leftSize > rightSize ? 1 : -1;
      } else {
         for (int indx = 0; indx < leftSize; indx++) {
            //if (left.get(indx).intValue() != right.get(indx).intValue()) {
            if (left.get(indx).compareTo(right.get(indx)) != 0) {
               rslt = left.get(indx) > right.get(indx) ? 1 : -1;
               break;
            }
         }
      }
   return rslt;
   }

}