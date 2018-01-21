package ru.job4j.junior001.iterator;


import java.util.Arrays;
import java.util.Collections;
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
	private Integer innerIterator;

	public Iterator<Integer> convert(Iterator<Iterator<Integer>> primeIt)  {


        Iterator<Integer> resultIt = new Iterator<Integer>() {
            //this.innerIterator
				Iterator<Integer> current = Collections.emptyIterator();

            @Override
            public boolean hasNext() {
            	if (primeIt.hasNext() && !current.hasNext()) {
						current = primeIt.next();
					}
					return current.hasNext();
            }

            @Override
            public Integer next() {
                while (!current.hasNext() && primeIt.hasNext()) {
						 current = primeIt.next();
					 }
                return current.next();
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

