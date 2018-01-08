package ru.job4j.lvl2junior.list;


/**
 * Ппоследний вошел, первый вышел.
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class SimpleSet<T> {

   DynamicList<T> simpleSet = new DynamicList<T>();

   public boolean alreadyExist(T value) {
      boolean result = false;

      for (T curValue : simpleSet) {
         if (curValue.equals(value)) {
            result = true;
            break;
         }
      }
      return result;
   }

   public boolean add(T value) {
      boolean result = false;
      if (!this.alreadyExist(value)) {
         simpleSet.add(value);
         result = true;
      }
      return result;
   }

   public T get(int index) {
      Object result = simpleSet.get(index);
      return (T) result;
   }

   public void delete(int position) {
      simpleSet.delete(position);
   }

   public static void main(String[] arg) {
      SimpleSet<String> ss = new SimpleSet<String>();
      ss.add("A1");
      ss.add("A1");
      ss.add("B2");
      ss.add("C3");
      ss.delete(0);
      ss.delete(0);

      System.out.println(ss.get(0));
      System.out.println(ss.get(1));
      System.out.println(ss.get(2));

   }

}