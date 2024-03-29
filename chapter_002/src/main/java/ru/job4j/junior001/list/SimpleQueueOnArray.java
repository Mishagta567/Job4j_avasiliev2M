package ru.job4j.junior001.list;


/**
 * Последний вошел, первый вышел.
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class SimpleQueueOnArray<T> {
    DynamicLinkedListOnArray<T> queue = new DynamicLinkedListOnArray<T>();

    public void add(T value) {
        queue.add(value);
    }

    public T get(int position) {
        return (T) queue.get(queue.getForwardRealIndex(position));
    }

    public T poll() {
        Object result = new Object();
        result = queue.get(queue.getForwardRealIndex(1));
        queue.delete(queue.getForwardRealIndex(1));
        return (T) result;
    }
}