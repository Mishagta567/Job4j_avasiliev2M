package ru.job4j.models;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class Item {
   /**
    * main просто выводит почти стандартную фразу
    * "World, Hello again"
    */
   private String name, description, comments;  // добавили comments
   private String id;
   private long create;
   public Item() {
   }
   public Item(String name, String description) {
      this.name = name;
      this.description = description;
   }
   public Item(String name, String description, long create) {
      this.name = name;
      this.description = description;
      this.create = create;
   }
   // все get
   public String getName() {
      return this.name;
   }
   public String getDescription() {
      return this.description;
   }
   public String getId() {
      return this.id;
   }
   public long getCreate() {
      return this.create;
   }
   public String getComments() {
      return comments;
   }

   /// все set
   public void setName(String name) {
      this.name = name;
   }
   public void setDescription(String description) {
      this.description = description;
   }
   public void setId(String id) {
      this.id = id;
   }
   public void setCreate(long create) {
      this.create = create;
   }
   public void setComments(String comments) {
      this.comments = comments;
   }
}