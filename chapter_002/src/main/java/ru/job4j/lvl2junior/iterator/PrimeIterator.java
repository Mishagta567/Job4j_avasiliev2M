package ru.job4j.lvl2junior.iterator;


import java.util.Iterator;

/**
 * Движение итератора только по простым элементам массива
 * @author   A_Vasiliev
 * @since    04.01.2018
 * @version  1.0.0
 */

public class PrimeIterator implements Iterator {
    private int[] primeNumbers;
    private int indx = 0;

    public PrimeIterator(int[] array) {
        this.primeNumbers = array;
    }

    // возвращает индекс следующего четного элемнта, начиная с startFrom (включая)
    private int hasNextEvan(int startFRom) {
        int rslt = -1;
        boolean prime = true;
        if (indx != -1) {
            // для начала нужно пройтись по всем оставшимся ячейкам что бы убедиться - если еще четные числа
            for (int indexArray = startFRom; indexArray < this.primeNumbers.length; indexArray++) {
                if (this.primeNumbers[indexArray] > 1) {
                    prime = true;
                    for (int indexNumb = 2; indexNumb < this.primeNumbers[indexArray]; indexNumb++) {
                        if (this.primeNumbers[indexArray] % indexNumb == 0) {
                            prime = false;
                            break;
                        }
                    }
                    if (prime) {
                        rslt = indexArray;
                        break;  // выходим и из первого цикла.
                    }
                }
            }
        }
        return rslt;
    }

    @Override
    public boolean hasNext() {
        return (indx < this.primeNumbers.length && hasNextEvan(indx) != -1);
    }

    @Override
    public Object next() {
        // выбросить ошибку можно по сравнению: if (rslt == -1), но что делать в этом случае - не понятно.
        indx = hasNextEvan(indx);
        int rslt = this.primeNumbers[hasNextEvan(indx)];
        indx = hasNextEvan(indx + 1);
        return rslt;
    }

    public static void main(String[] arg) {
        PrimeIterator pi = new PrimeIterator(new int[]{1, 2, 4, 5, 6, 7, 9, 11});
        int loopIndx = 0;
        while (pi.hasNext() && loopIndx < 10) {
            System.out.println(pi.next());
            loopIndx++;
        }
    }


}