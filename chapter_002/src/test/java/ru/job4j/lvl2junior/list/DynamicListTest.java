package ru.job4j.lvl2junior.list;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.junior001.list.DynamicList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicListTest {
   private Iterator<Integer> it;

   @Before
   public void setUp() {
      DynamicList<String> dl = new DynamicList<String>();
   }


   @Test
   public void add() throws Exception {
      setUp();
      DynamicList<String> dl = new DynamicList<String>();   //    Вопрос: почему тест не видит уже созданного dl выше?
      dl.add("A1");
      assertThat(dl.get(0), is("A1"));
      dl.add("B2");
      assertThat(dl.get(1), is("B2"));
      dl.add("C3");
      assertThat(dl.get(2), is("C3"));
   }

   @Test
   public void update() throws Exception {
      DynamicList<String> dl = new DynamicList<String>();   //    Вопрос: почему тест не видит уже созданного dl выше?
      dl.add("A1");
      assertThat(dl.get(0), is("A1"));
      dl.update("B2", 0);
      assertThat(dl.get(0), is("B2"));
   }

   @Test
   public void delete() throws Exception {
      DynamicList<String> dl = new DynamicList<String>();   //    Вопрос: почему тест не видит уже созданного dl выше?
      dl.add("A1");
      dl.add("B2");
      assertThat(dl.get(0), is("A1"));
      dl.delete(0);
      assertThat(dl.get(0), is("B2"));
   }

   @Test
   public void iteratorWorkCheck() throws ConcurrentModificationException {
      String allData = new String();
      DynamicList<String> dl = new DynamicList<String>();   //    Вопрос: почему тест не видит уже созданного dl выше?
      dl.add("A1");
      dl.add("B2");
      dl.add("C3");
      Iterator<String> it = dl.iterator();
      while (it.hasNext()) {
         allData = allData + it.next();
         // dl.add("E4");     // генерирует ConcurrentModificationException
      }
      assertThat(allData, is("A1B2C3"));
   }

}