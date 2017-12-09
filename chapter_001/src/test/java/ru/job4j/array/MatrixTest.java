package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {

   @Test
   public void myltiplyTableTest() {
      //напишите здесь тест, выводящий результат таблицы умножения
      int[][] shouldBe = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
      Matrix mtrx = new Matrix();
      int[][] resulttArr = mtrx.multiple(3);
      assertThat(shouldBe, is(resulttArr));
   }
}