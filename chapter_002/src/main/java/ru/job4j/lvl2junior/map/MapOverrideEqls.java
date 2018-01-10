package ru.job4j.lvl2junior.map;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

class UserOverrideEqls {
	public String name;
	public int children;
	public Calendar birthday;

	public UserOverrideEqls(String name, int children, Calendar birthday) {
		this.name = name;
		this.children = children;
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		UserOverrideEqls usr = (UserOverrideEqls) obj;
		if (this == obj) {
			result = true;
		} else if (this.name == usr.name && this.children == usr.children
				&&	this.birthday.getTimeInMillis() == usr.birthday.getTimeInMillis()) {
			result = true;
		}
		return result;
	}
}


public class MapOverrideEqls {

	public static void main(String[] args) {
		UserOverrideEqls ivan = new UserOverrideEqls("ivan", 1, new GregorianCalendar(2000, 1, 21));
		UserOverrideEqls alex = new UserOverrideEqls("ivan", 1, new GregorianCalendar(2000, 1, 21));

		System.out.printf("%s %s %s-%s-%s%s", ivan.name, ivan.children, ivan.birthday.get(Calendar.YEAR),
				ivan.birthday.get(Calendar.MONTH), ivan.birthday.get(Calendar.DAY_OF_MONTH), System.lineSeparator());

		Map<UserOverrideEqls, Object> map = new HashMap<>();
		map.put(ivan, ivan);
		map.put(alex, alex);

		System.out.println(map);

		System.out.printf("ivan hashCode: %s %S", ivan.hashCode(), System.lineSeparator());
		System.out.printf("alex hashCode: %s %S", alex.hashCode(), System.lineSeparator());
		System.out.printf("ivan=alex: %s", ivan.equals(alex));
	}
}