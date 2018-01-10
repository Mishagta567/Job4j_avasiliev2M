package ru.job4j.lvl2junior.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Простой массив
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class DynamicList<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;
    private int modCount = 0;

    public DynamicList() {
        this.objects = new Object[2];      // лучше конечно делать 100, но для тестов сделаем пока так
    }

    public void add(T value) {              // по аналогии можно создать уменьшение размера "листа".
        if (this.index >= objects.length - 1) {
            this.sizeIncrease();
            //System.out.println("Size increase work");
        }
        this.objects[index++] = value;
        this.modCount++;
    }

    public void update(T value, int position) {
        if (position <= this.index) {
            this.objects[position] = value;
            this.modCount++;
        }
    }

    public int getIndex() {
        return this.index;
    }

    public void delete(int realIndex) {
        if (realIndex <= this.index && realIndex >= 0) {
            for (int loopIndex = realIndex; loopIndex < this.index; loopIndex++) {
                this.objects[loopIndex] = this.objects[loopIndex + 1];  // перемещаем всю цепочку справа на лево до ячейки удаления
            }
            objects[this.index--] = null; // как бы удаляем последний объект и уменьшаем index на 1
            this.modCount++;
        }
    }

    public T get(int realIndex) {
        return (T) this.objects[realIndex];
    }

    private void sizeIncrease() {
        Object[] tempObject = new Object[objects.length * 2];
        for (int indx = 0; indx <= this.index; indx++) {
            tempObject[indx] = objects[indx];
        }
        objects = tempObject;
    }

    /** public static void main(String[] arg) {
        DynamicList<String> sa = new DynamicList<String>();
        System.out.println("index: " + sa.index + ", length: " + sa.objects.length);
        sa.insert("1-1");
        sa.insert("2-2");
        sa.insert("3-3");
        sa.insert("4-4");
        sa.insert("5-5");
        System.out.println(sa.get(0));
        System.out.println(sa.get(4));
        //ArrayIterator it = new ArrayIterator();

    } */

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator<T> {
        int current = 0;  // the current element we are looking at
        int expectedModCount = DynamicList.this.modCount;

        // return whether or not there are more elements in the array that
        // have not been iterated over.
        @Override
        public boolean hasNext() {
            boolean result = false;
            if (this.current < DynamicList.this.index) {
                result = true;
            }
            return result;
        }

        // return the next element of the iteration and move the current
        // index to the element after that.
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.expectedModCount != DynamicList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) DynamicList.this.objects[this.current++];
        }
    }


}