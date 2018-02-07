package ru.job4j.crud02;

import java.sql.Timestamp;

/**
 * Simple class for UserStore class, to work with user-data as an object
 */

public class UserCS {

   private String name;
   private String login;
   private String email;
   private final Timestamp insertedDate;

   public UserCS(String name, String logn, String eml, Timestamp insertedDate) {
      this.name = name;
      this.login = logn;
      this.email = eml;
      this.insertedDate = insertedDate;
   }

   public String getName() {
      return name;
   }

   public String getLogin() {
      return login;
   }

   public String getEmail() {
      return email;
   }

   public Timestamp getInsertedDate() {
      return insertedDate;
   }

   @Override
   public String toString() {
      return String.format("Name: %s Login: %s, Email: %s, Create date: %s",
              this.name, this.login, this.email, this.insertedDate.toString());
   }

}
