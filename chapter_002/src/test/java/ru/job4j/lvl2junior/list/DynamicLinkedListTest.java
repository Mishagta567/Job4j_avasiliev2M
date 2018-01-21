package ru.job4j.lvl2junior.list;

import org.junit.Test;
import ru.job4j.junior001.list.DynamicLinkedListOnArray;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicLinkedListTest {
   @Test
   public void add() throws Exception {
      DynamicLinkedListOnArray<String> dll = new DynamicLinkedListOnArray<String>();
      dll.add("A1");
      assertThat(dll.get(dll.getForwardRealIndex(1)), is("A1"));
   }

   @Test
   public void addValueInTheMidleOfChain() throws Exception {
      DynamicLinkedListOnArray<String> dll = new DynamicLinkedListOnArray<String>();
      dll.add("A1");
      dll.add("B2");
      dll.add("C3");
      assertThat(dll.get(dll.getForwardRealIndex(2)), is("B2"));
      dll.add("D4", 2);
      assertThat(dll.get(dll.getForwardRealIndex(2)), is("D4"));
   }

   @Test
   public void update() throws Exception {
      DynamicLinkedListOnArray<String> dll = new DynamicLinkedListOnArray<String>();
      dll.add("A1");
      dll.add("B2");
      dll.update("D2", dll.getForwardRealIndex(2));
      assertThat(dll.get(dll.getForwardRealIndex(2)), is("D2"));
   }

   @Test
   public void delete() throws Exception {
      DynamicLinkedListOnArray<String> dll = new DynamicLinkedListOnArray<String>();
      dll.add("A1");
      dll.add("B2");
      dll.add("C3");
      dll.delete(dll.getForwardRealIndex(2));
      assertThat(dll.get(dll.getForwardRealIndex(2)), is("C3"));
   }

   @Test
   public void get() throws Exception {
      DynamicLinkedListOnArray<String> dll = new DynamicLinkedListOnArray<String>();
      dll.add("A1");
      assertThat(dll.get(dll.getForwardRealIndex(1)), is("A1"));
   }

   @Test
   public void iterator() throws Exception {
      DynamicLinkedListOnArray<String> dll = new DynamicLinkedListOnArray<String>();
      dll.add("A1");  //  1   X1
      dll.add("B2");  //  2
      dll.add("C3");  //  3   X2
      dll.add("D4");  //  3   X2
      dll.add("E5");  //  2
      dll.add("G6");  //  1   X1
      String result = new String();

      dll.delete(dll.getBackwardRealIndex(1));
      dll.delete(dll.getBackwardRealIndex(2));
      dll.delete(dll.getForwardRealIndex(1));
      dll.delete(dll.getForwardRealIndex(2));
      Iterator<String> it2 = dll.iterator();
      while (it2.hasNext()) {
         result = result + it2.next();
      }
      assertThat(result, is("B2E5"));
   }

   @Test
   public void nodeTest() throws Exception {
      DynamicLinkedListOnArray<String> nd = new DynamicLinkedListOnArray<String>();
      nd.add("A1");  //  1   X1
      nd.add("B2");  //  2
      nd.add("C3");  //  3   X2
      nd.add("D4");  //  3   X2
      assertThat(nd.nodeForward(), is(false));

      nd.setNextValueForNodeTestOnly(3, 0);
      assertThat(nd.nodeForward(), is(true));
   }

}