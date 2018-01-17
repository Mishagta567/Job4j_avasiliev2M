package ru.job4j.synchroniz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStorageTest {
	@Test
	public void add() throws Exception {
		UserStorage usrs = new UserStorage();
		usrs.add(new User(1, 300));
		assertThat(usrs.users.get(0).getAmount(), is(300));
	}

	@Test
	public void update() throws Exception {
		UserStorage usrs = new UserStorage();
		User ivan = new User(1, 100);
		User ivanNew = new User(1, 300);
		assertThat(usrs.add(ivan), is(true));
		assertThat(usrs.update(ivanNew), is(true));
		assertThat(usrs.users.get(0).getAmount(), is(300));
	}

	@Test
	public void delete() throws Exception {
		UserStorage usrs = new UserStorage();
		User ivan = new User(1, 100);
		User jhon = new User(2, 300);
		usrs.add(ivan);
		usrs.add(jhon);
		assertThat(usrs.delete(ivan), is(true));
		assertThat(usrs.users.get(0).getAmount(), is(300));
	}

	@Test
	public void transfer() throws Exception {
		UserStorage usrs = new UserStorage();
		User ivan = new User(1, 500);
		User jhon = new User(2, 100);
		usrs.add(ivan);
		usrs.add(jhon);
		//usrs.transfer(1, 2, 100);
		assertThat(usrs.transfer(1, 2, 100), is(true));
		assertThat(usrs.users.get(0).getAmount(), is(400));
		assertThat(usrs.users.get(1).getAmount(), is(200));
	}

}