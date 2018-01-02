package ru.job4j.collections;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */


// для простоты будем счетать что колл-во денег и номер счета - int. Понятно что может быть не так
class Account {
   int value, requisites;
   public Account(int vlue, int rquisites) {
      this.value = vlue;
      this.requisites = rquisites;
   }
   public int getValue() {
      return this.value;
   }
   public int getRequisites() {
      return this.requisites;
   }
}


class BankUser {
   List<Account> accounts = new ArrayList<Account>();
   private String name, passport;

   public BankUser(String name, String pssprt) {
      this.name = name;
      this.passport = pssprt;
   }

   public String getName() {
      return this.name;
   }

   public String getPassport() {
      return this.passport;
   }

   public boolean eqauls(String pssrt) {
      return this.passport.equals(pssrt);
   }

   // Не получилось переопределить метод eqauls(Object obj) {
   // @Override
   public boolean eqauls(BankUser usr) {
      return this.passport.equals(usr.getPassport());
   }

   public List<Account> getAccounts() {
      return this.accounts;
   }

   // добавление счета пользователю
   public boolean AddAccount(String passport, Account account) {
      boolean rslt = false;
      if (this.eqauls(passport)) {
         accounts.add(account);
         rslt = true;
      }
      return rslt;
   }

   //
   public String printAllAccounts() {
      String rslt = System.lineSeparator();

      // не смог = не знаю, как с помощью итератора вытащить второе значение. В случае использования .next() - программа
      // перескакивает на следующую строчку.
      //Iterator<Account> iterator = accounts.iterator();
      //while (iterator.hasNext()) { rslt = String.format("%s Value: %s, Account: %s", rslt, iterator.next().getValue(), iterator.getRequisites());      }

      for (int indx = 0; indx < accounts.size(); indx++) {
         rslt += String.format("Value: %s, Account: %s %s", accounts.get(indx).getValue(), accounts.get(indx).getRequisites(), System.lineSeparator());
      }
      return  rslt;
   }

   //
   public void deleteAccountFromUser(String passport, Account account) {
      if (this.eqauls(passport)) {
         int indx = accounts.indexOf(account);
         if (indx != -1) {
            accounts.remove(indx);
         }
      }
   }

}


public class MapCheck {
   public List <BankUser> allAccounts = new ArrayList<>();

   //- добавление пользователя.
   public void addUser(BankUser bankuser) {
      this.allAccounts.add(bankuser);
   }

   // - удаление пользователя.
   public void deleteUser(User user) {
      int indx = allAccounts.indexOf(user);
      if (indx != -1) {
         allAccounts.remove(indx);
      }
   }

   // Правильно было бы переопределить метод equals что бы работал метод IndexOf
   public void deleteAccountFromUser(String passport, Account account) {
      for (int indx = 0; indx < allAccounts.size(); indx++) {
         if (allAccounts.get(indx).getPassport().equals(passport)) {
            int ind = allAccounts.get(indx).accounts.indexOf(account);
            if (ind != -1) {
               allAccounts.get(indx).accounts.remove(ind);
            }
            break;
         }
      }
   }

   // - получить список счетов для пользователя
   public List<Account> getUserAccounts (String passport) {
      List<Account> rslt = new ArrayList<>();
      for (int indx = 0; indx < allAccounts.size(); indx++) {
         if (allAccounts.get(indx).getPassport().equals(passport)) {
            rslt = allAccounts.get(indx).accounts;
            break; // если счета нашли - незачем продолжать поиск.
         }
      }
   return rslt;
   }

   //
   public static void main(String[] args) {
      MapCheck mc = new MapCheck();

      BankUser ivan = new BankUser("Ivan", "123");
      Account accOne = new Account(100, 1);
      Account accTwo = new Account(50, 2);
      ivan.AddAccount("123", accOne);
      ivan.AddAccount("123", accTwo);
      mc.addUser(ivan);

      BankUser jhon = new BankUser("Jhon", "345");
      Account accOn = new Account(1000, 3);
      Account accTw = new Account(500, 4);
      jhon.AddAccount("123", accOn);
      jhon.AddAccount("123", accTw);
      mc.addUser(jhon);

      BankUser ivan2 = new BankUser("Ivan", "123");

      int ind = mc.allAccounts.indexOf(ivan2);

      System.out.println(ind);
      System.out.println(mc.allAccounts.get(0).printAllAccounts());

   }

}