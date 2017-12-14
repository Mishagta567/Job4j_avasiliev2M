package ru.job4j.tracker;

import ru.job4j.models.*;
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
   private int position = 0;

    /**
    * Метод реализаущий добавление заявки в хранилище
    * У Петра           public Item add(Item item) {
    * Я переделал на    public void add(Item item) {
    *
    * @param item новая заявка
    */
   public void add(Item item) {
      item.setId(this.generateId());
      this.items[this.position++] = item;
      // return item;
   }

   /**
    * public void replace(String id, Item item);  - редактирование заявок -
    */
   public void replace(long id, Item item) {
      for (Item itm : items) {
         if (itm != null && item.getId().equals(id)) {
            itm = item;
         }
      }
   }

   /**
    * public void delete(String id);              - удаление заявки с данным id
    */
   public void delete(String id) {
      Item tmp  = new Item();
      int lngth = items.length;
      for (Item itm : items) {
         if (itm != null && itm.getId().equals(id)) {
            // перестановка и удаление последней ячейки
            itm = items[position];
            items[position] = null; // не знаю - можно ли так делать
            // Если хочется - по идее - можно обрезать массив. Но мне не очень нравится эта идея
            // if (position > 0) {
            //   System.arraycopy(items, 0, items, 0, position-- - 1);
            // }
         }
      }
   }

   /**
    * public Item[] findByName(String key);              - получение списка по имени
    */
   public Item[] findByName(String key) {
      Item[] result  = new Item[items.length];
      int eqlsLength = 0;

      for (int indx = 0; indx < items.length; indx++) {
         if ((items[indx] != null)
              && items[indx].getName().equals(key)) {
            result[indx] = items[indx];
            eqlsLength++;
         }
      }
      System.arraycopy(items, 0, result, 0, eqlsLength);
      return result;
   }

   /**
    * public Item[] findAll();              - получение списка всех заявок
    */
   public Item[] findAll() {
      int notNullLength = 0;
      Item[] result  = new Item[items.length];
      for (int indx = 0; indx < items.length; indx++) {
         if (items[indx] != null) {
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
      return String.valueOf(System.currentTimeMillis()); // + RN.next());
   }

   /**
    * Метод для нахождения заявки
    */
   protected Item frindById(String id) {
      Item result = null;
      for (Item item : items) {
         if (item != null && item.getId().equals(id)) {
            result = item;
            break;
         }
      }
      return result;
   }

   /**
    * Метода для вывода всех заявок.
    */
   public Item[] getAll() {
      Item[] result = new Item[this.position];
      for (int index = 0; index != this.position; index++) {
         result[index] = this.items[index];
         
      }
      return result;
   }
}