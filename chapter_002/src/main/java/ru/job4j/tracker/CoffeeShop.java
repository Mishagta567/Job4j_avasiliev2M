package ru.job4j.tracker;

import ru.job4j.models.Item;

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
   private int prc, pay, change, numberByOne, numberByTwo, numberByFive, numberByTen;

   public CoffeeShop(int price, int paid) {
      this.change  = paid - price;
      int toChange = this.change;
      this.prc = price;
      this.pay = paid;
      // Вычисляем сколько отдаем монет по 10
      this.numberByTen = (int) Math.floor(this.change / 10);
      toChange = toChange - this.numberByTen * 10;
      // Вычисляем сколько отдаем монет по 5
      this.numberByFive = (int) Math.floor(toChange / 5);
      toChange = toChange - this.numberByFive * 5;
      // Вычисляем сколько отдаем монет по 2
      this.numberByTwo = (int) Math.floor(toChange / 2);
      toChange = toChange - this.numberByTwo * 2;
      // Вычисляем сколько отдаем монет по 1
      this.numberByOne = toChange;
   }

     public static void main(String[] args) {
        CoffeeShop coffeSh = new CoffeeShop(41, 100);
        System.out.printf("Ваша сдача: %s - %s = %s %s", coffeSh.pay, coffeSh.prc, coffeSh.change, System.lineSeparator());
        System.out.printf("Выдача по монетам: 10 x %s, 5 x %s, 2 x %s, 1 x %s",
              coffeSh.numberByTen, coffeSh.numberByFive, coffeSh.numberByTwo, coffeSh.numberByOne);
     }
}