package ru.job4j.lvl2junior.map;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

class UserOverrideEqlsAndHC {
	public String name;
	public int children;
	public Calendar birthday;

	public UserOverrideEqlsAndHC(String name, int children, Calendar birthday) {
		this.name = name;
		this.children = children;
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + this.children + this.birthday.get(Calendar.YEAR)
				+ this.birthday.get(Calendar.MONTH) + this.birthday.get(Calendar.DAY_OF_MONTH);
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		UserOverrideEqlsAndHC usr = (UserOverrideEqlsAndHC) obj;
		if (this == obj) {
			result = true;
		} else if (this.name.equals(usr.name)  && this.children == usr.children) {
				//&&	this.birthday.getTimeInMillis() == usr.birthday.getTimeInMillis()) {
			result = true;
		}
		return result;
	}
}


public class MapOverrideEqlsAndHC {

	public static void main(String[] args) {

		UserOverrideEqlsAndHC ivan = new UserOverrideEqlsAndHC("ivan", 1, new GregorianCalendar(2000, 1, 21));
		UserOverrideEqlsAndHC alex = new UserOverrideEqlsAndHC("ivan", 1, new GregorianCalendar(2000, 1, 21));

		Map<UserOverrideEqlsAndHC, Object> map = new HashMap<>();
		map.put(ivan, ivan);
		map.put(alex, alex);

		System.out.println(map);

		System.out.printf("ivan hashCode: %s %S", ivan.hashCode(), System.lineSeparator());
		System.out.printf("alex hashCode: %s %S", alex.hashCode(), System.lineSeparator());

		System.out.printf("ivan=alex: %s", ivan.equals(alex));
		System.out.println("4");
	}
}