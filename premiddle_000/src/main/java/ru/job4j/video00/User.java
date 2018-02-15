package ru.job4j.video00;

import java.sql.Timestamp;

/**
 * Simple class for UserStore class, to work with user-data as an object
 */

public class User {
   private int id;
   private int role;
   private String name;
   private String login;
   private String email;
   private String password;
   private Timestamp insertedDate;

   public User(String name, String logn, String eml, Timestamp insertedDate) {
      this.name = name;
      this.login = logn;
      this.email = eml;
      this.insertedDate = insertedDate;
   }

   public User(String name, String logn, String password, String eml, Timestamp insertedDate) {
      this.name = name;
      this.login = logn;
      this.password = password;
      this.email = eml;
      this.insertedDate = insertedDate;
   }

   public User() {

   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String nme) {
      this.name = nme;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Timestamp getInsertedDate() {
      return insertedDate;
   }

   public void setInsertedDate(Timestamp time) {
      this.insertedDate = time;
   }

   public void setRole(int role) {
      this.role = role;
   }

   public int getRole() {
      return role;
   }

   @Override
   public String toString() {
      return String.format("Name: %s Login: %s, Email: %s, Create date: %s",
              this.name, this.login, this.email, this.insertedDate.toString());
   }

}
