package ru.job4j.junior001.map;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Тестируем Map<User, Object>. НЕ переопределяем никакие методы.
 * @author   A_Vasiliev
 * @since    09.01.2018
 * @version  1.0.0
 */

class User {
	public String name;
	public int children;
	public Calendar birthday;

	public User(String name, int children, Calendar birthday) {
		this.name = name;
		this.children = children;
		this.birthday = birthday;
	}
}

public class MapTestOne {

	public static void main(String[] args) {
		User ivan = new User("Ivan", 1, new GregorianCalendar(2000, 1, 21));
		User alex = new User("Ivan", 1, new GregorianCalendar(2000, 1, 21));

		System.out.printf("%s %s %s-%s-%s%s", ivan.name, ivan.children, ivan.birthday.get(Calendar.YEAR),
				ivan.birthday.get(Calendar.MONTH), ivan.birthday.get(Calendar.DAY_OF_MONTH), System.lineSeparator());

		Map<User, Object> map = new HashMap<>();
		map.put(ivan, ivan);
		map.put(alex, alex);

		System.out.println(map);

		System.out.printf("ivan hashCode: %s %S", ivan.hashCode(), System.lineSeparator());
		System.out.printf("alex hashCode: %s %S", alex.hashCode(), System.lineSeparator());

		System.out.printf("ivan=alex: %s", ivan.equals(alex));

	}

}