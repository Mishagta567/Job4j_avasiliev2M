package ru.job4j.collections;

import org.hamcrest.core.Is;
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

		// тк. паспорта одиннаковые, mapCheck говорит что это один и тот же клиент:
		//System.out.println();

      assertThat(tm.allBankUsers.get(ivan).equals(tm.allBankUsers.get(jhon)), Is.is(true));


      List<Account> jhonAccounts2 = tm.getUserAccounts("123");
      //System.out.println(jhonAccounts2.size());
      // У Jhon-а 2 счета
      assertThat(jhonAccounts2.size(), Is.is(2));

      //System.out.println(jhonAccounts2.indexOf(new Account(0, 4)));

      tm.deleteAccount(jhon, 3);
      jhonAccounts2 = tm.getUserAccounts("123");
      //System.out.println(jhonAccounts2.size());
      // Теперь у Jhon-а 1 счет
      assertThat(jhonAccounts2.size(), Is.is(1));
      //
      tm.deleteAccount(jhon, 4);
      jhonAccounts2 = tm.getUserAccounts("123");
      //System.out.println(jhonAccounts2.size());
      // У Jhon-а не осталось счетов
      assertThat(jhonAccounts2.size(), Is.is(0));


	}

}