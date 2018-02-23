package ru.job4j.filter06;

import java.sql.Timestamp;

/**
 * Simple class for UserStore class, to work with user-data as an object
 */

public class Role06 {

   private int id;
   private String role;

   public Role06(int id, String role) {
      this.id = id;
      this.role = role;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   @Override
   public String toString() {
      return String.format("ID: %s Role: %s",
              this.id, this.role);
   }

}