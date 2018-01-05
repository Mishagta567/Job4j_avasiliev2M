package ru.job4j.lvl2junior.iterator;


import java.util.Iterator;

/**
 * Движение итератора только по четным элементам массива (минуя нечетные элементы)
 * @author   A_Vasiliev
 * @since    04.01.2018
 * @version  1.0.0
 */

public class EvenNumbers implements Iterator {
    private int[] evenNumbers;
    private int indx = 0;

    public EvenNumbers(int[] array) {
        this.evenNumbers = array;
    }

    // возвращает индекс следующего четного элемнта, начиная с startFrom (включая)
    private int hasNextEvan(int startFRom) {
        int rslt = -1;
        if (indx != -1) {
            // для начала нужно пройтись по всем оставшимся ячейкам что бы убедиться - если еще четные числа
            for (int i = startFRom; i < this.evenNumbers.length; i++) {
                if (this.evenNumbers[i] % 2 == 0) {
                    rslt = i;
                    break; // нет смысла искать еще четные. Можем выйти из цикла.
                }
            }
        }
        return rslt;
    }

    @Override
    public boolean hasNext() {
        return (indx < this.evenNumbers.length && hasNextEvan(indx) != -1);
    }

    @Override
    public Object next() {
        // выбросить ошибку можно по сравнению: if (rslt == -1), но что делать в этом случае - не понятно.
        indx = hasNextEvan(indx);
        int rslt = this.evenNumbers[hasNextEvan(indx)];
        indx = hasNextEvan(indx + 1);
        return rslt;
    }

}

