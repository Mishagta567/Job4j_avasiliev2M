package ru.job4j.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class SortUserTest {

   @Test
   public void checkSortMetod() {
      SortUser sortUser = new SortUser();
      List<SortUser.User> usersOrig = Arrays.asList(
            new SortUser.User("zuma", 95), new SortUser.User("ivan", 55), new SortUser.User("petr", 19));
      TreeSet<SortUser.User> usersSorted = new TreeSet<SortUser.User>();
      usersSorted = (TreeSet<SortUser.User>) sortUser.sort(usersOrig);
      String usersSortedReal = usersSorted.toString();
      assertThat(usersSortedReal, is("[User{age: 19, name='petr'}, User{age: 55, name='ivan'}, User{age: 95, name='zuma'}]"));
   }

   @Test
   public void sortNameLength() {
      SortUser sortUser = new SortUser();
      List<SortUser.User> usersOrig = Arrays.asList(
            new SortUser.User("Сергей-эгей", 60),
            new SortUser.User("Сергей", 95),
            new SortUser.User("Серый", 55),
            new SortUser.User("С", 20));
      String result = sortUser.sortNameLength(usersOrig).toString();
      String iExpect = "[User{age: 20, name='С'}, User{age: 55, name='Серый'}, User{age: 95, name='Сергей'}, User{age: 60, name='Сергей-эгей'}]";
      assertThat(result, is(iExpect));
   }

   @Test
   public void sortByAllFields() {
      SortUser sortUser = new SortUser();
      List<SortUser.User> usersOrig = Arrays.asList(
            new SortUser.User("Сергей", 18),
            new SortUser.User("Сергей", 95),
            new SortUser.User("Azam", 55),
            new SortUser.User("Azam", 20));
      String result = sortUser.sortByAllFields(usersOrig).toString();
      String iExpect = "[User{age: 20, name='Azam'}, User{age: 55, name='Azam'}, User{age: 18, name='Сергей'}, User{age: 95, name='Сергей'}]";
      assertThat(result, is(iExpect));
   }

}