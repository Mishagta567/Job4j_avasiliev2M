package ru.job4j.junior001.list;


/**
 * Ппоследний вошел, первый вышел.
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class SimpleStack<T> {
    //DynamicLinkedListOnArray<T>  = new DynamicLinkedListOnArray<T>();
    private final DynamicLinkedList<T> stack = new DynamicLinkedList<T>();

    public void add(T value) {
        stack.add(value);
    }

    public T get(int position) {
        return (T) stack.getNode(position);
    }

    public T poll() {
        Object result = new Object();
        result = stack.get(stack.size());
        stack.remove(stack.size());
        return (T) result;
    }

}