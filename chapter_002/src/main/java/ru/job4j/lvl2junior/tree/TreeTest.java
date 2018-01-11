package ru.job4j.lvl2junior.tree;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;


/**
 * Тестируем Tree
 * @author   A_Vasiliev
 * @since    09.01.2018
 * @version  1.0.0
 */


public class TreeTest {

	public static final class User implements Comparable<User> {
		public String name;
		public User(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(User o) {
			return this.name.compareTo(o.name);
		}
	}

	public static final class UserTwo {
		public String name;
		public UserTwo(String name) {
			this.name = name;
		}
	}

	public static void main(String[] arg) {
		TreeSet<User> users = new TreeSet<>();
		users.add(new User("petr"));

		TreeSet<UserTwo> usersTwo = new TreeSet<>(new Comparator<UserTwo>() {
			@Override
			public int compare(UserTwo o1, UserTwo o2) {
				int reresult = 0;
				if (o1.name != null && o2.name != null) {
					reresult = o1.name.compareTo(o2.name);
				} else if (o1.name == null && o2.name == null) {
					reresult = 0;
				} else if (o2.name == null) {
					reresult = -1;
				} else if (o1.name == null) {
					reresult = -1;
				}
				return reresult;
			}
		});

		usersTwo.add(new UserTwo("ivan"));



	}


}