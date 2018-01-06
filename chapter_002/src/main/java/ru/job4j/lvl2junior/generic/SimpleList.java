package ru.job4j.lvl2junior.generic;



/**
 * Реализовать Store
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class SimpleList<E> {
   Object[] objects;

   public SimpleList(int size) {
      objects = new Object[size];
   }

   public void add(E value) {

   }

   public E get(int position) {
       return (E) this.objects[position];
   }


}