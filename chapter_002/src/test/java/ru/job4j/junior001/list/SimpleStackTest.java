package ru.job4j.junior001.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
   /**
    * Первый вошел, последний вышел
    */
   @Test
   public void getedItemsShouldBeInSameOrder() {
      int[] items = new int[] {0, 1, 2, 3};
      int[] expected = new int[] {3, 2, 1, 0};
      SimpleStack<Integer> queue = new SimpleStack<Integer>();
      for (int i : items) {
         queue.add(i);
      }
      int[] actual = new int[items.length];
      for (int i = 0; i < items.length; i++) {
         actual[i] = queue.poll();
      }
      assertThat(actual, is(expected));
   }

   @Test
   public void getedItemsShouldBeInSameOrderString() {
      String[] items = new String[] {"0", "1", "2", "3"};
      String[] expected = new String[] {"3", "2", "1", "0"};
      SimpleStack<String> queue = new SimpleStack<String>();
      for (String i : items) {
         queue.add(i);
      }
      String[] actual = new String[items.length];
      for (int i = 0; i < items.length; i++) {
         actual[i] = queue.poll();
      }
      assertThat(actual, is(expected));
   }

}