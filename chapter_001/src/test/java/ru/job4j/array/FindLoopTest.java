package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindLoopTest {
   // убедимся что метод корректно находит
   @Test
   public void whenSearchLoopCanFind() {
      int[] start = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      FindLoop fnd = new FindLoop();
      int rst = fnd.indexOf(start, 5);
      assertThat(5, is(rst));
   }

   // убедимся что метод возвращает -1 если НЕ находит
   @Test
   public void whenSearchLoopCantFind() {
      int[] start = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      FindLoop fnd = new FindLoop();
      int rst = fnd.indexOf(start, 50);
      assertThat(-1, is(rst));
   }

}