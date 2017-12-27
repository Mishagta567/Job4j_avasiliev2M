package ru.job4j.tracker;


import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;


public class CoffeeShopTest {

   @Test
   public void loockForChange() {
      CoffeeShop сoffeeSh = new CoffeeShop(41, 100);
      String result = сoffeeSh.getChange();
      String expectResult = "Вы заплатили: 100. Стоимость кофе: 41. Ваша сдача: 59. Выдача по монетам: 10 x 5, 5 x 1, 2 x 2, 1 x 0";
      assertThat(expectResult, is(result));
   }
}