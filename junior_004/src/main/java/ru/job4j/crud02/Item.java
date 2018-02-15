package ru.job4j.crud02;

import java.util.List;

/**
 * Simple class to work with Hibernamte
 */

public class Item {
   private UserCS author;
   private List<Item> items;

   public List<Item> getItems() {
      return items;
   }

   public void setItems(List<Item> items) {
      this.items = items;
   }

   public UserCS getAuthor() {
      return author;
   }

   public void setAuthor(UserCS author) {
      this.author = author;
   }

}
