package ru.job4j.filter06;

import java.sql.Timestamp;

/**
 * Simple class for UserStore class, to work with user-data as an object
 */

public class User06 {

   private int id;
   private String login;
   private String password;
   private String name;
   private String email;
   private Timestamp insertedDate;
   private int roleId;
   private String roleName;

   public User06(int id, String login, String password, String name,
           String email, Timestamp insertedDate, int roleId, String roleName) {
      this.id = id;
      this.login = login;
      this.password = password;
      this.name = name;
      this.email = email;
      this.insertedDate = insertedDate;
      this.roleId = roleId;
      this.roleName = roleName;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Timestamp getInsertedDate() {
      return insertedDate;
   }

   public void setInsertedDate(Timestamp time) {
      this.insertedDate = time;
   }

   public int getRoleId() {
      return roleId;
   }

   public void setRoleId(int roleId) {
      this.roleId = roleId;
   }

   public String getRoleName() {
      return roleName;
   }

   public void setRoleName(String roleName) {
      this.roleName = roleName;
   }

   @Override
   public String toString() {
      return String.format("Name: %s Login: %s, Email: %s, Create date: %s",
              this.name, this.login, this.email, this.insertedDate.toString());
   }

}