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

}