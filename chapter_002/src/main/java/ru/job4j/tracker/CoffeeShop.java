package ru.job4j.tracker;

/**
 * Задание. Вычисляем сколько сдачи мы должны отдать клиенту с кофейного аппарата.
 * @author   AVasiliev
 * @since    20.12.2017
 * @version  1.0.0
 */

public class CoffeeShop  {
   /**
    *
    */
   private int price, paid;

   public CoffeeShop(int price, int paid) {
      this.price = price;
      this.paid = paid;
   }

   public String getChange() {
      int change, numberByOne, numberByTwo, numberByFive, numberByTen;
      change  = this.paid - this.price;
      int toChange = change;
      String rslt = new String();
      // Вычисляем сколько отдаем монет по 10
      numberByTen = (int) Math.floor(change / 10);
      toChange = toChange - numberByTen * 10;
      // Вычисляем сколько отдаем монет по 5
      numberByFive = (int) Math.floor(toChange / 5);
      toChange = toChange - numberByFive * 5;
      // Вычисляем сколько отдаем монет по 2
      numberByTwo = (int) Math.floor(toChange / 2);
      toChange = toChange - numberByTwo * 2;
      // Вычисляем сколько отдаем монет по 1
      numberByOne = toChange;

      rslt = String.format("Вы заплатили: %s. Стоимость кофе: %s. Ваша сдача: %s.", this.paid, this.price, change);
      rslt = String.format("%s Выдача по монетам: 10 x %s, 5 x %s, 2 x %s, 1 x %s", rslt, numberByTen, numberByFive, numberByTwo, numberByOne);
      return rslt;
   }
/**
     public static void main(String[] args) {
        CoffeeShop coffeSh = new CoffeeShop(41, 100);
        System.out.println(coffeSh.getChange());
     }  // */
}