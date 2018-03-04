package ru.job4j.ioс00;

import javafx.application.Application;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class UserStorageTest {

   @Test
   public void whenAddUserThenShouldSafeIt() throws Exception {
      MemoryStorage memory = new MemoryStorage();
      UserStorage userStorage = new UserStorage(memory);
      userStorage.add(new User());
   }
}