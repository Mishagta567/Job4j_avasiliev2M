package ru.job4j.lvl2junior.list;


/**
 * Ппоследний вошел, первый вышел.
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class SimpleStack<T> {
    DynamicLinkedList<T> stack = new DynamicLinkedList<T>();

    public void add(T value) {
        stack.add(value);
    }

    public T get(int position) {
        return (T) stack.get(stack.getBackwardRealIndex(position));
    }

    public T poll() {
        Object result = new Object();
        result = stack.get(stack.getBackwardRealIndex(1));
        stack.delete(stack.getBackwardRealIndex(1));
        return (T) result;
    }

}