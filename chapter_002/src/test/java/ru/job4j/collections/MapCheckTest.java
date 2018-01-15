package ru.job4j.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class MapCheckTest {
	@Test
	public void testAllWhatNeed() throws Exception {
		MapCheck tm = new MapCheck();

		List<Account> ivanAccounts = new ArrayList<Account>();
		ivanAccounts.add(new Account(100, 1));
		ivanAccounts.add(new Account(200, 2));
		BankUser ivan = new BankUser("Ivan", "123");
		tm.allBankUsers.put(ivan, ivanAccounts);

		List<Account> jhonAccounts = new ArrayList<Account>();
		jhonAccounts.add(new Account(500, 3));
		jhonAccounts.add(new Account(600, 4));
		BankUser jhon = new BankUser("Jhon", "123");
		tm.allBankUsers.put(jhon, jhonAccounts);

		System.out.println(tm.allBankUsers.get(ivan).equals(tm.allBankUsers.get(jhon)));

	}

}