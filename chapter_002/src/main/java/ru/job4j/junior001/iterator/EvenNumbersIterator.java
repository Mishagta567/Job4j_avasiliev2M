package ru.job4j.junior001.iterator;


import java.util.Iterator;

/**
 * Движение итератора только по четным индексам.  Ну типа возвращает через ячейку.
 * @author   A_Vasiliev
 * @since    04.01.2018
 * @version  1.0.0
 */

public class EvenNumbersIterator implements Iterator {
    int[] evenNumbers;
    int indx = 1;

    public EvenNumbersIterator(int[] array) {
        this.evenNumbers = array;
    }

    @Override
    public boolean hasNext() {
        return (indx < this.evenNumbers.length);
    }

    @Override
    public Object next() {
        int rslt =  this.evenNumbers[indx];
        this.indx = this.indx + 2;
        return rslt;
    }

}

