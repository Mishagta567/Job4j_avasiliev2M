package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
   @Test
   public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
      //напишите здесь тест, проверяющий переворот массива с чётным числом элементов, например {2, 6, 1, 4}.
      Turn turn = new Turn();
      int[] oldArr = {2, 6, 1, 4};
      int[] newArr = new int[4];
      newArr = turn.back(oldArr);
      assertThat(oldArr, is(newArr));
   }

   @Test
   public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
      //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов, например {1, 2, 3, 4, 5}.
      Turn turn = new Turn();
      int[] oldArr = {1, 2, 3, 4, 5};
      int[] newArr = new int[5];
      newArr = turn.back(oldArr);
      assertThat(oldArr, is(newArr));
   }
}