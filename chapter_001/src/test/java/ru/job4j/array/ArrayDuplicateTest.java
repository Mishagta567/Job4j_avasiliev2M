package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {

   @Test
   public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
      //напишем здесь тест, проверяющий удаление дубликатов строк из массива строк.
      ArrayDuplicate arr = new ArrayDuplicate();
      String[] start  = {"Привет", "Мир", "Привет", "Супер", "Мир"};
      String[] rst    = arr.remove(start);
      String[] shouldB = {"Привет", "Мир", "Супер"};
      assertThat(shouldB, is(rst));
   }
}