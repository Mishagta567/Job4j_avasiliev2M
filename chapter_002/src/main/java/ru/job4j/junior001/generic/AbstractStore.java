package ru.job4j.junior001.generic;



/**
 * Простой массив (или должна была быть коллекция?)
 * @author   A_Vasiliev
 * @since    05.01.2018
 * @version  1.0.0
 */

public abstract class AbstractStore<T extends Base> implements Store {
    private Object[] objects;
    private int index = 0;

    public AbstractStore(int size) {
        this.objects = new Object[size];
    }

    @Override
    public void add(Base model) {
        if (this.index < objects.length) {
            this.objects[index++] = model;
        }
    }

    @Override
    public boolean update(String id, Base model) {
        int position = new Integer(id);
        boolean result = false;
        if (position <= this.index) {
            this.objects[position] = model;
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        int position = new Integer(id);
        boolean result = false;
        if (position <= this.index && position >= 0) {
            for (int loopIndex = position; loopIndex < this.index; loopIndex++) {
                this.objects[loopIndex++] = this.objects[loopIndex];  // перемещаем всю цепочку справа на лево до ячейки удаления
            }
            objects[this.index--] = null; // как бы удаляем последний объект и уменьшаем index на 1
            result = true;
        }
        return result;
    }

    @Override
    public Base get(String id) {
        //int position = new Integer(id);
        return (Base) this.objects[new Integer(id)];
    }
}