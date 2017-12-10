package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckWordTest {

   // Проверка с наличием sub
   @Test
   public void whenSubstrExist() {
      CheckWord ch = new CheckWord();
      boolean rst = ch.contains("Привет", "иве");
      boolean exp = true;
      assertThat(rst, is(exp));
   }

   // Проверка с отсутсвием sub
   @Test
   public void whenSubstrDoesntExist() {
      CheckWord ch = new CheckWord();
      boolean rst = ch.contains("Привет", "ххх");
      boolean exp = false;
      assertThat(rst, is(exp));
   }

   // теперь с индексами:
   // Проверка с наличием sub
   @Test
   public void whenSubstrExistUsingIndex() {
      CheckWord ch = new CheckWord();
      boolean rst = ch.containsWithindexOf("Привет", "иве");
      boolean exp = true;
      assertThat(rst, is(exp));
   }

   // Проверка с отсутсвием sub
   @Test
   public void whenSubstrDoesntExistUsingIndex() {
      CheckWord ch = new CheckWord();
      boolean rst = ch.containsWithindexOf("Привет", "ххх");
      boolean exp = false;
      assertThat(rst, is(exp));
   }

}