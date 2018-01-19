package ru.job4j.junior001.iterator;


import java.util.Iterator;

/**
 * Движение итератора только по четным
 * @author   A_Vasiliev
 * @since    04.01.2018
 * @version  1.0.0
 */

public class MatrixIterator implements Iterator {
    int[][] matrixArry;
    int indOne = 0;
    int indTwo = 0;

    public MatrixIterator(int[][] array) {
        this.matrixArry = array;
    }

    @Override
    public boolean hasNext() {
        return (indOne < this.matrixArry.length && indTwo < this.matrixArry[indOne].length);
    }


    @Override
    public Object next() {
        int rslt;
        rslt = this.matrixArry[indOne][indTwo];
        indTwo++;
        if (indTwo >= this.matrixArry[indOne].length) {
            indTwo = 0;
            indOne++;
        }
        return rslt;
    }

    /** / Простая проверка, вывод на панель:
    public static void main(String[] arg) {
        MatrixIterator mi = new MatrixIterator(new int[][]{{1, 2}, {4, 5, 6, 7}, {8, 9, 10, 11}});
        int ind = 0;
        while (mi.hasNext() && ind < 10) {
            System.out.println(mi.next());
            ind++;
        }
    } // */

}

