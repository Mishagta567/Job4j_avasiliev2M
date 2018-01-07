package ru.job4j.lvl2junior.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ппоследний вошел, первый вышел.
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class SimpleStack<T> {
    DynamicLinkedList<T> ss = new DynamicLinkedList<T>();

    public void add(T value) {
        ss.add(value);
    }




}