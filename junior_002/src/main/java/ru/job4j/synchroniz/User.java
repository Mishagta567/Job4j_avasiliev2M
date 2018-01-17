package ru.job4j.synchroniz;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Класс хранилища пользователей UserStorage [#1104]
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class User {
	private int id;
	private int amount;

	public User(int id, int amount) {
		this.amount = amount;
		this.id = id;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public boolean checkNewAmount(int amnt) {
		return (this.amount + amnt > 0);
	}


	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		return this.id == user.id;
	}

}