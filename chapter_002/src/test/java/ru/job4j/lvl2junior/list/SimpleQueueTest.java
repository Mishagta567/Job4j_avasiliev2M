package ru.job4j.lvl2junior.list;

import org.junit.Test;
import ru.job4j.junior001.list.SimpleQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {
   @Test
   public void add() throws Exception {
      SimpleQueue<String> sq = new SimpleQueue<String>();
      sq.add("A1");
      sq.add("B2");
      sq.add("C3");
      assertThat(sq.get(1), is("A1"));
      assertThat(sq.get(2), is("B2"));
      assertThat(sq.get(3), is("C3"));
   }

   @Test
   public void poll() throws Exception {
      SimpleQueue<String> sq = new SimpleQueue<String>();
      sq.add("A1");
      sq.add("B2");
      sq.add("C3");
      sq.add("D4");
      assertThat(sq.poll(), is("A1"));
      assertThat(sq.poll(), is("B2"));
      assertThat(sq.poll(), is("C3"));
   }

}