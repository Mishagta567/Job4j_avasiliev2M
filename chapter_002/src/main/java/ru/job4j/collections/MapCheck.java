package ru.job4j.collections;


import java.util.*;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    02.01.2018
 * @version  1.0.0
 */


// для простоты будем счетать что номер счета - int. Понятно что может быть не так. Понятно что можем переделать.

class Account {
	double value;
	int requisites;
	public Account(int vlue, int rquisites) {
		this.value = vlue;
		this.requisites = rquisites;
	}
	public double getValue() {
		return this.value;
	}
	public int getRequisites() {
		return this.requisites;
	}
	public void setValue(double vl) {
		this.value = vl;
	}
}

class BankUser {
	private String name, passport;
	public BankUser(String nm, String pssprt) {
		this.name = nm;
		this.passport = pssprt;
	}
	public String getName() {
		return name;
	}
	public String getPassport() {
		return passport;
	}

	@Override
	public int hashCode() {
		return this.passport.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		BankUser userTwo = (BankUser) obj;

		return this.passport.equals(userTwo.getPassport());
	}
}


public class MapCheck implements Comparator<BankUser> {
   public Map<BankUser, List<Account>> allBankUsers = new HashMap<BankUser, List<Account>>();

	@Override
	public int compare(BankUser o1, BankUser o2) {
		return o1.getPassport().compareTo(o2.getPassport());
	}



   // Перевод денег от одного, другому или себе
   public boolean moneyTransfer(int ammount, String passpFrom, int requisitesFrom, String passporTo, int requisitesTo) {
      boolean rslt = false;

      return rslt;
   }

   // Добавить пользователя:
   public void addUser(BankUser user) {
      allBankUsers.put(user, new ArrayList<Account>());
   }

   // Удаление пользователя:
   public void deleteUser(BankUser user) {
      allBankUsers.remove(user);
   }

   // добавим новый account пользователю.
   public void addAccount(BankUser user, Account account) {
      List<Account> accounts = allBankUsers.get(user);
      accounts.add(account);
   }

   // удалим экаунт у пользователя.
   public void deleteAccount(BankUser user, int rqsites) {
      List<Account> accounts = allBankUsers.get(user);
      for (int indx = 0; indx < accounts.size(); indx++) {
         if (accounts.get(indx).getRequisites() == rqsites) {
            accounts.remove(indx);
            break;                         // выходим из цикла после нахождения и удаления.
         }
      }
   }

   // Перечисляем кому-то дополнительную сумму. Если -addValue, то вычитаем.
   public boolean changeBalance(BankUser user, int rqsites, double addValue) {
      List<Account> accounts = allBankUsers.get(user);
      boolean rslt = false;
      double oldValue;
      for (int indx = 0; indx < accounts.size(); indx++) {
         if (accounts.get(indx).getRequisites() == rqsites) {
            oldValue = accounts.get(indx).getValue();
            if (oldValue + addValue > 0) {
               accounts.get(indx).setValue(oldValue + addValue);
               rslt = true;
            }
            break; // нет смысла продолжать цикл, если нашли счет
         }
      }
      return rslt;
   }

   // Теперь сделаем метод для перевода:
   // Конечно нужно переделать метод что бы работал не по BankUser а по паспорту.
   public boolean transferMoney(BankUser srcPassport, int srcRequisite,
                                 BankUser destPassport, int dstRequisite, double amount) {
      boolean rslt = false;
      if (changeBalance(srcPassport, srcRequisite, -amount)) {    //  добавить получателю только если удалось вычесть у отправителя
         if (changeBalance(destPassport, dstRequisite, amount)) {
            rslt = true;
         } else {       // если не удалось зачислить, нужно сделать откат первого списания
            changeBalance(srcPassport, srcRequisite, amount);
         }
      }
      return rslt;
   }


   // выведем все счета, которые есть у пользователя:
   public String printAll(List<Account> accnt) {
      String result = System.lineSeparator();
      for (int indx = 0; indx < accnt.size(); indx++) {
         result += String.format("%s руб. на счете: %s%s", accnt.get(indx).getValue(), accnt.get(indx).getRequisites(), System.lineSeparator());
      }
      return result;
   }

   // тесты пока делал так, т.к. так проще наблюдать. Надеюсь тесты не обязательно писать к этим методам?
   public static void main(String[] arg) {
      MapCheck tm = new MapCheck();

      //List<Account> ivanAccounts = new ArrayList<Account>();
      //ivanAccounts.add(new Account(100, 1));
      //ivanAccounts.add(new Account(200, 2));
      //BankUser ivan = new BankUser("Ivan", "123");
      //tm.allBankUsers.put(ivan, ivanAccounts);
		//
      //List<Account> jhonAccounts = new ArrayList<Account>();
      //jhonAccounts.add(new Account(500, 3));
      //jhonAccounts.add(new Account(600, 4));
      //BankUser jhon = new BankUser("Jhon", "567");
      //tm.allBankUsers.put(jhon, jhonAccounts);

      // получить множество записей
      //Set<Map.Entry<BankUser, List<Account>>> set = tm.allBankUsers.entrySet();

      //System.out.println(tm.printAll(tm.allBankUsers.get(ivan)));

      // Добавим 222 руб и посмотрим на результат
      //tm.changeBalance(ivan, 2, 222);
      //System.out.println(tm.printAll(tm.allBankUsers.get(ivan)));
      //System.out.println(tm.printAll(tm.allBankUsers.get(jhon)));
		//
      //tm.transferMoney(ivan, 2, jhon, 3, 533.50);
      //System.out.println("После трансфера");
      //System.out.println(tm.printAll(tm.allBankUsers.get(ivan)));
      //System.out.println(tm.printAll(tm.allBankUsers.get(jhon)));
   }
}
