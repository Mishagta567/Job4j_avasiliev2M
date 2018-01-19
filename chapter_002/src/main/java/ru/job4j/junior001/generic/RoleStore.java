package ru.job4j.junior001.generic;



/**
 * Реализовать Store
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class RoleStore<Role> extends AbstractStore {


   public RoleStore(int size) {
      super(size);
   }

   public void main(String[] arg) {
      User ivan = new User("U1");
      ru.job4j.junior001.generic.Role admin = new ru.job4j.junior001.generic.Role("R1");
      RoleStore<Role> roleSt = new RoleStore<Role>(10);
      roleSt.add(ivan);          // Могу выполнить, что НЕ правильно.
      roleSt.add(admin);

      SimpleArray<Role> roleSt2 = new SimpleArray<Role>(10);
      //roleSt2.add(ivan);       // Не могу выполнить, что и требовалось.
      //roleSt2.add(admin);      // Не могу выполнить, что НЕ правильно.

      //AbstractStore<Role> roleSt3 = new AbstractStore<Role>(10);      // тоже нельзя выполнять.

      System.out.print("Yo");
   }

}