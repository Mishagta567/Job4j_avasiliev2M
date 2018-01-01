package ru.job4j.tracker;


import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;


public class CoffeeShopTest {

   @Test
   public void loockForChange() {
      CoffeeShop coffeeShop = new CoffeeShop(41, 100);
      int[] rslt = new int[4];
      rslt = coffeeShop.getChange();
      int[] expectResult = {5, 1, 2, 0};
      assertThat(expectResult, is(rslt));
   }
}