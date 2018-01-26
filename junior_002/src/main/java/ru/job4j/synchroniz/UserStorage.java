package ru.job4j.synchroniz;


import java.util.ArrayList;
import java.util.List;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Класс хранилища пользователей UserStorage [#1104]
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */

@ThreadSafe
public class UserStorage {
	List<User> users = new ArrayList<User>();

	public synchronized boolean add(User user) {
		boolean result = false;
		if (!this.users.contains(user)) {
			users.add(user);
			result = true;
		}
		return result;
	}

	public synchronized boolean update(User user) {
		boolean result = false;
		if (this.users.contains(user)) {
			// нам не обязательно обнавлять ID, достаточно - amount.
			users.get(users.indexOf(user)).setAmount(user.getAmount());
			result = true;
		}
		return result;
	}

	public synchronized boolean delete(User user) {
		boolean result = false;
		if (this.users.contains(user)) {
			this.users.remove(user);
			result = true;
		}
		return result;
	}

	public synchronized boolean transfer(int fromID, int toId, int amount) {
		boolean result = false;
		// проверяем: есть ли у нас вообще Users c nfrbvb ID
		if (this.users.contains(new User(fromID, 0)) && this.users.contains(new User(toId, 0))) {
			// находим этих пользователей
			User userFrom = users.get(users.indexOf(new User(fromID, 0)));
			User userTwo = users.get(users.indexOf(new User(toId, 0)));
			// проверяем: можем ли мы сделать данный перевод (т.е. достаточно ли денег на счетах)
			if (userFrom.checkNewAmount(-amount) && userTwo.checkNewAmount(amount)) {
				//теперь собственно делаем обнавления "сумм на счетах":
				users.get(users.indexOf(new User(fromID, 0))).setAmount(userFrom.getAmount() - amount);
				users.get(users.indexOf(new User(toId, 0))).setAmount(userTwo.getAmount() + amount);
				result = true;
			}
		}
		return result;
	}

}