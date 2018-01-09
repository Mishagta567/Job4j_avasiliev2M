package ru.example.collections;

import org.junit.jupiter.api.Test;
import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;


import java.util.*;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */

public class MapTest {

   public static final class User {
      public String name;
      public int id;


      public User(String name) {
      	this.name = name;
		}

		@Override
		public int hashCode() {
			int result = name != null ? name.hashCode() : 0;
			//result = result * 31 + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			//return super.equals(obj);
			boolean result = true;

			if (this == obj) {
				result = true;
			} else if (obj == null || getClass() != obj.getClass()) {
				result = false;
			} else {
				User user = (User) obj;
				if (name != null ? !name.equals(user.name) : user.name != null) {
					result = false;
				}
			}

			return result;
		}
	}

	public void map() {
		User first = new User("Petr");
		User second = new User("Petr");

		Map<User, String> map = new HashMap<>();
		map.put(first, "first put");
		map.put(second, "second put");


	}


	public static void main(String[] arg) {
      Set<User> users = new TreeSet<>();
      users.addAll(Arrays.asList(new User("zuma"), new User("ivan"), new User("petr")));
      System.out.println(users);

      /**
      List<User> users = new ArrayList<User>();
      users.addAll(Arrays.asList(new User("zuma"), new User("ivan"), new User("petr")));
      System.out.println(users);
      users.sort(
            new Comparator<User>() {
               @Override
               public int compare(User o1, User o2) {
                  return o1.name.compareTo(o2.name);
               }
            }
      );
      System.out.println(users);

       * boolean result = users.equals("Petr");
      for (User user : users) {
         System.out.println(user);
      }
      Iterator<User> it = users.iterator();
      System.out.println(it.next());

      Iterator<User> it = users.iterator();
      while(it.hasNext()) {
         System.out.println(it.next());
      }  // */

   }
}