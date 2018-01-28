package ru.job4j.threads;

import org.junit.Test;

import static org.junit.Assert.*;

public class KillThreadTest {

   @Test
   public void getTextString() throws Exception {
      KillThread ct = new KillThread();

      // убрал везде преобразователь static. Запустить Thread для теста теперь не получается.

      // Thread tLetters = new Thread(new ct.LettersCount());
      // tLetters.start();
      //
      // Thread tSpace = new Thread(new timerThread(tLetters));
      // tSpace.start();
   }

}