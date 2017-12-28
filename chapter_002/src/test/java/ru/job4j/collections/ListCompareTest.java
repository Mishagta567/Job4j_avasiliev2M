package ru.job4j.collections;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static sun.nio.cs.Surrogate.is;

public class ListCompareTest {

   @Test
   public void compareWhenBiggerLeft() {
      ListCompare myLists = new ListCompare(Arrays.asList(1, 8), Arrays.asList(1, 2, 3));
      int result = myLists.compare(myLists.getLeft(), myLists.getRight());
      int iExpect = -1;
      assertThat(result, Is.is(iExpect));
   }

   @Test
   public void compareWhenBiggerRight() {
      ListCompare myLists = new ListCompare(Arrays.asList(1, 8, 9), Arrays.asList(1, 2));
      int result = myLists.compare(myLists.getLeft(), myLists.getRight());
      int iExpect = 1;
      assertThat(result, Is.is(iExpect));
   }

   @Test
   public void compareWhenEqual() {
      ListCompare myLists = new ListCompare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
      int result = myLists.compare(myLists.getLeft(), myLists.getRight());
      int iExpect = 0;
      assertThat(result, Is.is(iExpect));
   }

}