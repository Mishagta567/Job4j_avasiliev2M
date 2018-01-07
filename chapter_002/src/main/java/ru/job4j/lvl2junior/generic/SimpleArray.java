package ru.job4j.lvl2junior.generic;



/**
 * Простой массив (или должна была быть коллекция?)
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public class SimpleArray<T> {
    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T value) {
        if (this.index < objects.length) {
            this.objects[index++] = value;
        }
    }

    public void update(T value, int position) {
        if (position <= this.index) {
            this.objects[position] = value;
        }
    }

    public void delete(int position) {
        if (position <= this.index && position >= 0) {
            for (int loopIndex = position; loopIndex < this.index; loopIndex++) {
                this.objects[loopIndex++] = this.objects[loopIndex];  // перемещаем всю цепочку справа на лево до ячейки удаления
            }
            objects[this.index--] = null; // как бы удаляем последний объект и уменьшаем index на 1
        }
    }

    public T get(int position) {
        return (T) this.objects[position];
    }

    public static void main(String[] arg) {
        SimpleArray<String> sa = new SimpleArray(10);
        sa.add("1-1");
        sa.add("2-2");
        System.out.println(sa.get(0));
        System.out.println(sa.get(1));
    }

}