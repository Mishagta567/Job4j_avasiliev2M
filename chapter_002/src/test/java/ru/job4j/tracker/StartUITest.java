package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.models.Item;
import java.util.Scanner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

   /**
   @Test
   public void whenAddItem() {
      Tracker   tracker = new Tracker();
      String[]  answers = {"0", "Name-1", "Descr-11", "6"};
      StubInput stInput = new StubInput(answers);
      StartUI strt = new StartUI(stInput, tracker);
      strt.init();
      // Теперь сделаем обычную проверку.
       assertThat(tracker.getAll()[0].getName(), is("Name-1"));
   }

   @Test
   public void whenAddTwoItemsAndChangeOne() {
      Tracker   tracker = new Tracker();
      String[]  answers = {"0", "Name-1", "Descr-1", "0", "Name-2", "Descr-2", "2", "Name-3", "Descr-3", "1", "6"};
      StubInput stInput = new StubInput(answers);
      StartUI strt = new StartUI(stInput, tracker);
      strt.init();
      // Теперь сделаем обычную проверку.
      assertThat(tracker.getAll()[0].getName(), is("Name-3"));
   }

   /***
   @Test
   public void whenAddTwoItemsAndDeleteFirst() {
      Tracker   tracker = new Tracker();
      String[]  answers = {"1", "Name-1", "Descr-1", "1", "2", "7"};
      StubInput stInput = new StubInput(answers);
      StartUI strt = new StartUI(stInput, tracker);
      strt.init();
      // Теперь сделаем обычную проверку.
      //assertThat(tracker.getAll()[0].getName(), is("Name-2"));
   }     //

   @Test
   public void whenAddTwoItemsAndSearchByName() {
      Tracker   tracker = new Tracker();
      String[]  answers = {"0", "Name-1", "Descr-1", "0", "Name-2", "Descr-2", "4", "Name-2", "1", "6"};
      StubInput stInput = new StubInput(answers);
      StartUI strt = new StartUI(stInput, tracker);
      strt.init();
      // Теперь сделаем обычную проверку.
      assertThat(tracker.findByName("Name-2")[0].getName(), is("Name-2"));
   }

   @Test
   public void whenAddTwoItemsAndSearchByID() {
      Tracker   tracker = new Tracker();
      String[]  answers = {"0", "Name-1", "Descr-1", "0", "Name-2", "Descr-2", "5", "2", "1", "6"};
      StubInput stInput = new StubInput(answers);
      StartUI strt = new StartUI(stInput, tracker);
      strt.init();
      // Теперь сделаем обычную проверку.
      assertThat(tracker.frindById("2").getName(), is("Name-2"));
   }
// */

}