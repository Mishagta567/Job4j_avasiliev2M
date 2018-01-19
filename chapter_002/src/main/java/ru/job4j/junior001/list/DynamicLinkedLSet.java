package ru.job4j.junior001.list;


import java.util.Iterator;

/**
 * Set не массивах. Не принимает дубликаты. Почти все из DynamicLinkedList.
 * НЕ УДАЛОСЬ реализовать прохождение итератора в обратную сторону.
 *
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class DynamicLinkedLSet<T> implements Iterable<T> {

    DynamicLinkedList<T> lnkSet = new DynamicLinkedList<>();

    public boolean alreadyExist(T value) {
        boolean result = false;
        Iterator<T> itr = this.lnkSet.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean add(T value) {
        boolean result = false;
        if (!this.alreadyExist(value)) {
            lnkSet.add(value);
            result = true;
        }
        return result;
    }

    public int getForwardRealIndex(int position) {
        return lnkSet.getForwardRealIndex(position);
    }

    public void delete(int realIndex) {
        lnkSet.delete(realIndex);
    }

	public T get(int postion) {
		return (T) lnkSet.get(lnkSet.getForwardRealIndex(postion));
	}

    // по аналогии можно сделать все нужные методы. Т.к. пока не нужно - останавливаемся.


    @Override
    public Iterator<T> iterator() {
        return new DnmcSetIterator();
    }

    class DnmcSetIterator implements Iterator<T> {
        Iterator<T> it = lnkSet.iterator();

        @Override
        public boolean hasNext() {
            return it.hasNext();  // false;
        }

        @Override
        public T next() {
            return it.next();
        }
    }

}