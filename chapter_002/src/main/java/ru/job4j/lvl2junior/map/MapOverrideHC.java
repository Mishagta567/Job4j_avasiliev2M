package ru.job4j.lvl2junior.map;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

class UserOverrideHC {
	public String name;
	public int children;
	public Calendar birthday;

	public UserOverrideHC(String name, int children, Calendar birthday) {
		this.name = name;
		this.children = children;
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + this.children + this.birthday.get(Calendar.YEAR)
			+ this.birthday.get(Calendar.MONTH) + this.birthday.get(Calendar.DAY_OF_MONTH);
	}
}


public class MapOverrideHC {

	public static void main(String[] args) {
		UserOverrideHC ivan = new UserOverrideHC("Ivan", 1, new GregorianCalendar(2000, 1, 21));
		UserOverrideHC alex = new UserOverrideHC("Ivan", 1, new GregorianCalendar(2000, 1, 21));

		System.out.printf("%s %s %s-%s-%s%s", ivan.name, ivan.children, ivan.birthday.get(Calendar.YEAR),
				ivan.birthday.get(Calendar.MONTH), ivan.birthday.get(Calendar.DAY_OF_MONTH), System.lineSeparator());

		Map<UserOverrideHC, Object> map = new HashMap<>();
		map.put(ivan, ivan);
		map.put(alex, alex);

		System.out.println(map);

		System.out.printf("ivan hashCode: %s %S", ivan.hashCode(), System.lineSeparator());
		System.out.printf("alex hashCode: %s %S", alex.hashCode(), System.lineSeparator());
		System.out.printf("ivan=alex: %s", ivan.equals(alex));
	}
}