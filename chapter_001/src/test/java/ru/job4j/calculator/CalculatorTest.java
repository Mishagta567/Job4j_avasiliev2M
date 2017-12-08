package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Alex Vasiliev from Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 06/12/2017
 */

public class CalculatorTest {
   @Test
   public void whenAddOnePlusOneThenTwo() {
      Calculator calc = new Calculator();
      calc.add(1D, 1D);
      double result = calc.getResult();
      // Здесь специально ошибка что бы проверить работу теста. Тест что-то не работает
      double expected = 2D;
      assertThat(result, is(expected));
   }

   // Задание: сделать аналоги для deduct
   @Test
   public void whenThreeDeductOneThenTwo() {
      Calculator calc = new Calculator();
      calc.deduct(3D, 1D);
      double result = calc.getResult();
      double expected = 2D;
      assertThat(result, is(expected));
   }

   // Задание: сделать аналоги для multiply
   @Test
   public void whenThenThreeMultiplyTwoThenSix() {
      Calculator calc = new Calculator();
      calc.multiply(3D, 2D);
      double result = calc.getResult();
      double expected = 6D;
      assertThat(result, is(expected));
   }

   // Задание: сделать аналоги для divide
   @Test
   public void whenThenSixDivideTwoThenThree() {
      Calculator calc = new Calculator();
      calc.divide(6D, 2D);
      double result = calc.getResult();
      double expected = 3D;
      assertThat(result, is(expected));
   }

}