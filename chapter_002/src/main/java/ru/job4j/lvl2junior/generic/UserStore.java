package ru.job4j.lvl2junior.generic;

public class UserStore<T> {
   //private AbstractStore<User>[] storeArray = new AbstractStore<User>(10);

   private Object[] objects;
   private int index = 0;

   public UserStore(int size) {
      this.objects = new Object[size];
   }

   public void add(T value) {
         this.objects[index++] = value;
   }

   public boolean update(String id, Base model) {
      int position = new Integer(id);
      boolean result = false;
      if (position <= this.index) {
         this.objects[position] = model;
         result = true;
      }
      return result;
   }

   public boolean delete(String id) {
      int position = new Integer(id);
      boolean result = false;
      if (position <= this.index && position >= 0) {
         for (int loopIndex = position; loopIndex < this.index; loopIndex++) {
            this.objects[loopIndex++] = this.objects[loopIndex];  // перемещаем  всю  цепочку справа на лево до ячейки удаления
         }
         objects[this.index--] = null; // как бы удаляем последний объект и уменьшаем index на 1
         result = true;
      }
      return result;
   }

   public static void main(String[] arg) {
      User ivan = new User("U1");
      Role admin = new Role("R1");
      UserStore<User> userSt = new UserStore<User>(10);

      userSt.add(ivan);
      //userSt.insert(admin);       // Не могу выполнить, что и требовалось.

      SimpleArray<User> userSt2 = new SimpleArray<User>(10);
      userSt2.add(ivan);
      //userSt2.insert(admin);      // Не могу выполнить, что и требовалось.
      System.out.print("Yo");
   }

}