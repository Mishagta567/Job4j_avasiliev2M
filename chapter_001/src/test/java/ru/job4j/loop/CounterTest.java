package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
   //  Убедимся что тест нормально работает для простого отрезка от 1 до 5

   @Test
   public void countFromOneToFive() {
      Counter c = new Counter();
      int result = c.add(1, 5);
      assertThat(result, is(6));
   }

}