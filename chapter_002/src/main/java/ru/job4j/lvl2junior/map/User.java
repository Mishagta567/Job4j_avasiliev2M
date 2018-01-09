package ru.job4j.lvl2junior.map;


import java.util.Calendar;

/**
 * Класс User для map
 * @author   A_Vasiliev
 * @since    09.01.2018
 * @version  1.0.0
 */

public class User {
   String name;
   int children;
	Calendar birthday;

	public User(String name, int children, Calendar birthday) {
		this.name = name;
		this.children = children;
		this.birthday = birthday;
	}
}