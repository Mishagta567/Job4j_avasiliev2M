package ru.job4j.lvl2junior.iterator;

import org.junit.Test;
import ru.job4j.junior001.generic.SimpleArray;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class SimpleArrayTest {

   SimpleArray<String> smplA = new SimpleArray<String>(10);

   @Test
   public void checkAllFunctionsHere() throws Exception {
      smplA.add("A1");
      smplA.add("B2");
      String[] expect = new String[10];
      expect[0] = "A1";
      expect[1] = "B2";
      assertThat(smplA.get(1), is("B2"));
      //assertThat(smplA, is(expect));   // не понятно почему так не работает
      smplA.update("C3", 1);
      assertThat(smplA.get(1), is("C3"));
      smplA.add("D4");
      smplA.delete(1);
      assertThat(smplA.get(1), is("D4"));
   }

}