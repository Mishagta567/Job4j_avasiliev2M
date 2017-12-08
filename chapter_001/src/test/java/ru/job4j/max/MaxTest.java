package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alex Vasiliev (parsentev@yandex.ru)
 * @version $Id$
 * @since 07/12/2017
 */
public class MaxTest {
   // Странно: почему-то НЕ отправляется.
   @Test
   public void whenFirstLessThenSecond() {
      Max maxim = new Max();
      int result = maxim.max(1, 2);
      assertThat(result, is(2));
   }

   @Test
   public void whenFirstMoreThenSecond() {
      Max maxim = new Max();
      int result = maxim.max(5, 2);
      // Ниже специально ошибка что бы поймать сообщение об ошибке, которое НЕ выходит.
      // Понятно что должно быть assertThat(result, is(5)) ;
      assertThat(result, is(0));
   }
}