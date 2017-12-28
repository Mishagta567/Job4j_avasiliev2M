package ru.job4j.collections;


import java.util.HashMap;
import java.util.List;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author    A_Vasiliev
 * @since     22.12.2017
 * @version   1.0.0
 */

public class UserConvert {

   public HashMap<Integer, User> process(List<User> list) {
      HashMap<Integer, User> result = new HashMap<Integer, User>();
      for (User usr : list) {
         result.put(usr.getId(), usr);
      }
   return result;
   }

}