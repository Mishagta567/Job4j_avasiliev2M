package ru.job4j.tracker;

import ru.job4j.models.*;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @version $Id$
 * @since 12.12.2017
 */
public class Tracker {
   /**
    * Массив для хранение заявок.
    */   
   private final Item[] items = new Item[100];      
   private static final Random RN = new Random(); // не использую.

   /**
    * Указатель ячейки для новой заявки.
    */
   public int position = 0;

    /**
    * Метод реализаущий добавление заявки в хранилище
    * У Петра           public Item0 add(Item0 Item0) {
    * Я переделал на    public void add(Item0 Item0) {
    *
    * @param item новая заявка
    */
   public void add(Item item) {
      item.setId(this.generateId());
      this.items[this.position] = item;
      this.position++;
      // return Item0;
   }

   /**
    * public void replace(String id, Item0 Item0);  - редактирование заявок -
    */
   public boolean replace(String id, Item item) {
      boolean rslt = false;
      /** for (Item0 itm : items) {
         if (itm != null && itm.getId().equals(id)) {
            itm = Item0;
            rslt = "Yes";
            break;
         }
      } */
      for (int ind = 0; ind < position; ind++) {
         if (items[ind].getId().equals(id)) {
            items[ind] = item;
            items[ind].setId(id);
            rslt = true;
            break;
         }
      }
      return rslt;
   }

   /**
    * public void delete0(String id);              - удаление заявки с данным id
    */
   public boolean delete(String id) {
      boolean rst = false;
      //Item0 tmp  = new Item0();
      //int lngth = items.length;
      for (int ind = 0; ind < position; ind++) {
         if (items[ind].getId().equals(id)) {
            // перестановка и удаление последней ячейки
            if (ind < position) {
               /**
               // на место удалаемой записи переношу последнюю
               items[ind] = items[position - 1];
               // на место последней записываю пустую запись. */
               //items[ind] = null;           // Что-то НЕ РАБОТАЕТ
               //tmp = Arrays.copyOf(items, position); */
               for (int m = ind; m < position - 1; m++) {
                  items[m] = items[m + 1];
               }
               Item itm = new Item();
               items[position - 1] = itm;
               position--;
               rst = true;
               //System.
            }
            break;
            //else {               rst = "Yes, but...";            }
            // Если хочется - по идее - можно обрезать массив. Но мне не очень нравится эта идея
            // if (position > 0) {
            //   System.arraycopy(items, 0, items, 0, position-- - 1);
            // }
         }
      }
      return rst;
   }

   /**
    * public Item0[] findByName(String key);              - получение списка по имени
    */
   public Item[] findByName(String key) {
      Item[] result  = new Item[items.length];
      int resultLngth = 0;
      //for (int indx = 0; indx < items.length; indx++) {
      for (int indx = 0; indx < position; indx++) {
         if (items[indx].getName().equals(key)) {
            result[resultLngth++] = items[indx];
         }
      }
      Item[] fnl = new Item[resultLngth];
      fnl = Arrays.copyOf(result, resultLngth);
      //System.arraycopy(items, 0, result, 0, eqlsLength);
      return fnl;
   }

   /**
    * public Item0[] findAll();              - получение списка всех заявок
    */
   public Item[] findAll() {
      int notNullLength = 0;
      Item[] result  = new Item[items.length];
      //for (int indx = 0; indx < items.length; indx++) {   Ниже не лучше: ?
      for (int indx = 0; indx < this.position; indx++) {
         if ((items[indx] != null)
               && !(items[indx].getId().equals("null"))) {
            result[indx] = items[indx];
            notNullLength++;
         }
      }
      System.arraycopy(items, 0, result, 0, notNullLength);
      return result;
   }

   /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
   private String generateId() {
      //Реализовать метод генерации.
      return String.valueOf(System.currentTimeMillis() + this.position); // + RN.next());
   }

   /**
    * Метод для нахождения заявки
    */
   protected Item frindById(String id) {
         Item result  = new Item();
         //for (int indx = 0; indx < items.length; indx++) {
         for (int indx = 0; indx < position; indx++) {
            if (items[indx].getId().equals(id)) {
               result = items[indx];
               break;
            }
         }
         //System.arraycopy(items, 0, result, 0, eqlsLength);
         return result;
   }

   /**
    * Метода для вывода всех заявок.
    */
   public Item[] getAll() {
      Item[] result = new Item[this.position];
      for (int indx = 0; indx != this.position; indx++) {
         result[indx] = this.items[indx];
      }
      return result;
   }

}