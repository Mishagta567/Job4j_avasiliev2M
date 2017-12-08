package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
   @Test
   public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
      Paint paint = new Paint();
      String ln = System.lineSeparator();
      String result = paint.piramid(2);
      String expected = String.format(" ^ %s^^^%s", ln, ln);
      assertThat(result, is(expected));
   }

   @Test
   public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
      //напишите здесь тест, проверяющий формирование пирамиды для высоты 3.
      Paint  paint = new Paint();
      String ln = System.lineSeparator();
      String result = paint.piramid(3);
      String expected = String.format("  ^  %s ^^^ %s^^^^^%s", ln, ln, ln);
      assertThat(result, is(expected));
   }
}