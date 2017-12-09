package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {

   @Test
   public void checkTwoArrays() {
      int[] shouldBe = {1, 4, 9, 16, 25};
      Square sqr = new Square();
      int[] resulttArr = sqr.calculate(5);
      assertThat(shouldBe, is(resulttArr));
   }
}