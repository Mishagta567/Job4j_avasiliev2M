package ru.job4j.collections;


import java.util.*;

/**
 * 1-003-5-3 Тестововое задание. Реализовать коллекцию Map для банка
 *
 * @author   A_Vasiliev
 * @since    20.01.2018
 * @version  1.0.2
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



   // Перевод денег от одного, другому или себе сделан ниже.

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

   // getUserAccount
	public List<Account> getUserAccounts (String passport) {
		return allBankUsers.get(new BankUser("AnyName", passport));
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

}
