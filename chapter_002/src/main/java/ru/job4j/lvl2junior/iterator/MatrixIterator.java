package ru.job4j.lvl2junior.iterator;


import java.util.Iterator;

/**
 * Движение итератора только по четным
 * @author   A_Vasiliev
 * @since    04.01.2018
 * @version  1.0.0
 */

public class MatrixIterator implements Iterator{
    int[][] matrixArry;
    int indOne = 0;
    int indTwo = 0;

    public MatrixIterator(int[][] array) {
        this.matrixArry = array;
    }

    @Override
    public boolean hasNext() {
        return (indOne < this.matrixArry.length && indTwo < this.matrixArry[0].length);
    }


    @Override
    public Object next() {
        int rslt =  this.matrixArry[indOne][indTwo];
        indTwo++;
        if (indTwo >= this.matrixArry[0].length ) {
            indTwo = 0;
            indOne++;
        }
        return rslt;
    }


}

