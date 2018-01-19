package ru.job4j.junior001.iterator;


import java.util.Arrays;
import java.util.Iterator;

/**
 * Конвертирование итератора итераторов.
 * @author   A_Vasiliev
 * @since    04.01.2018
 * @version  1.0.0
 */

class IteratorOfIterators {
    private Iterator<Iterator<Integer>> primeIterator;

    public IteratorOfIterators(Iterator<Iterator<Integer>> primeIt) {
        this.primeIterator = primeIt;
    }
}

public class Converter { //implements Iterator{
    private Iterator<Integer> mainIterator;
    private Integer innerIterator;
    private int mainIteratorIndex = -1;
    private int innerIteratorIndex = -1;

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> primeIt)  {
        Iterator<Integer> rsltIterator;
        if (mainIteratorIndex == -1 && innerIteratorIndex == -1) {
            mainIterator = primeIt.next();
            //innerIterator = mainIterator.next();
            mainIteratorIndex++;
            //innerIteratorIndex++;
        }

        Iterator<Integer> resultIt = new Iterator<Integer>() {
            //this.innerIterator

            @Override
            public boolean hasNext() {
                return (mainIterator.hasNext() || primeIt.hasNext());
            }

            @Override
            public Integer next() {
                if (mainIterator.hasNext()) {
                    innerIterator = mainIterator.next();
                    mainIteratorIndex++;
                } else if (primeIt.hasNext()) {
                    mainIterator = primeIt.next();
                    innerIterator = mainIterator.next();
                    mainIteratorIndex++;
                    innerIteratorIndex++;
                } else {  // здесь нужно как-то выбрасывать ошибку что больше ячеек нет
                    mainIterator = primeIt.next(); // строчка должна сгенерировать ошибку
                    innerIterator = 888;
                }
                return innerIterator;
            }
        };
        return resultIt;
    }

    public static void main(String[] arg) {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter converter = new Converter();
        Iterator<Integer> it = converter.convert(its);
        //int temp = 0;

        while (it.hasNext()) { // && temp < 16) {
            System.out.println(it.next());
            //temp++;
        }

    }

}

