package ru.job4j.lvl2junior.iterator;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.junior001.iterator.EvenNumbersIterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EvenNumbersIteratorTest {

   private Iterator<Integer> it;

   @Before
   public void setUp() {
      it = new EvenNumbersIterator(new int[] {1, 2, 3, 4, 5, 6, 7});
   }

   @Test //(expected = NoSuchElementException.class)
   public void shouldReturnEvenNumbersSequentially() {
      assertThat(it.hasNext(), is(true));
      assertThat(it.next(), is(2));
      assertThat(it.hasNext(), is(true));
      assertThat(it.next(), is(4));
      assertThat(it.hasNext(), is(true));
      assertThat(it.next(), is(6));
      assertThat(it.hasNext(), is(false));
//      it.next();
   }

   @Test
   public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
      assertThat(it.hasNext(), is(true));
      assertThat(it.hasNext(), is(true));
      assertThat(it.next(), is(2));
      assertThat(it.next(), is(4));
      assertThat(it.next(), is(6));
   }

   @Test
   public void  shouldReturnFalseIfNoAnyEvenNumbers() {
      it = new EvenNumbersIterator(new int[] {1});
      assertThat(it.hasNext(), is(false));
   }

}