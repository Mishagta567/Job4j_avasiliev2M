package ru.job4j.lvl2junior.list;

import org.junit.Test;
import ru.job4j.junior001.list.SimpleStack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleStackTest {
   @Test
   public void add() throws Exception {
      SimpleStack<String> stack = new SimpleStack<String>();
      stack.add("A1");
      assertThat(stack.get(1), is("A1"));
   }

   @Test
   public void get() throws Exception {
      SimpleStack<String> stack = new SimpleStack<String>();
      stack.add("A1");
      stack.add("B2");
      stack.add("C3");
      assertThat(stack.get(1), is("C3"));
      assertThat(stack.get(2), is("B2"));
      assertThat(stack.get(3), is("A1"));
   }

   @Test
   public void poll() throws Exception {
      SimpleStack<String> stack = new SimpleStack<String>();
      stack.add("A1");
      stack.add("B2");
      stack.add("C3");
      assertThat(stack.poll(), is("C3"));
      assertThat(stack.poll(), is("B2"));
      assertThat(stack.poll(), is("A1"));
   }

}