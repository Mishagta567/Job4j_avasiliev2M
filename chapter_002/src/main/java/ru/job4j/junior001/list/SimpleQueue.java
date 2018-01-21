package ru.job4j.junior001.list;


/**
 * Последний вошел, первый вышел.
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class SimpleQueue<T> {
    /**
     * Создадим лист на базе динамического.
     */
    private final DynamicLinkedList<T> list = new DynamicLinkedList<>();

    /**
     * Простая очередь: первый вошел, первый вышел.
     *
     * @param item -- item to enqueue
     */
    public void add(T item) {
        this.list.add(item);
    }

    /**
     * Вернуть первый из очереди
     *
     * @return first enqueued item
     */
    public T get() {
        T result = this.list.get(0);
        this.list.remove(0);
        return result;
    }
}