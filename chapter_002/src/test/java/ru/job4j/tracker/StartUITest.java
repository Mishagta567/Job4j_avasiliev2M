package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.models.Item;

import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

   @Test
   public void whenRunStart() {
      Scanner scanner = new Scanner(System.in);

      Tracker   tracker = new Tracker();
      String[]  answers = {"0", "N-1", "Decr-11", "0", "Name-2", "Descr-2", "1", "6"};
      //String[]  answers = {"0", "N-1", "Decr-11", "1", "6"};
      StubInput stInput = new StubInput(answers);
      StartUI strt = new StartUI(stInput, tracker);
      strt.init();

      // Теперь сделаем обычную проверку.
      //Item item = new Item("N-1", "Decr-11");
      //Item scnd = new Item("Name-2", "Descr-2", 456L);
       //assertThat(tracker.getAll()[0], is(item));



   }
}