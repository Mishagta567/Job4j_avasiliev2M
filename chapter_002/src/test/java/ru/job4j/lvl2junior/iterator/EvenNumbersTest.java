package ru.job4j.lvl2junior.iterator;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.junior001.iterator.EvenNumbers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EvenNumbersTest {
   private Iterator<Integer> it;

   @Before
   public void setUp() {
      it = new EvenNumbers(new int[]{11, 12, 14, 15, 16, 17, 19, 21});
   }

   @Test //(expected = NoSuchElementException.class)
   public void shouldReturnEvenNumbersSequentially() {
      assertThat(it.hasNext(), is(true));
      assertThat(it.next(), is(12));
      assertThat(it.hasNext(), is(true));
      assertThat(it.next(), is(14));
      assertThat(it.hasNext(), is(true));
      assertThat(it.next(), is(16));
      assertThat(it.hasNext(), is(false));
//      it.next();
   }

   @Test
   public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
      assertThat(it.hasNext(), is(true));
      assertThat(it.hasNext(), is(true));
      assertThat(it.next(), is(12));
      assertThat(it.next(), is(14));
      assertThat(it.next(), is(16));
   }

   @Test
   public void  shouldReturnFalseIfNoAnyEvenNumbers() {
      it = new EvenNumbers(new int[]{1});
      assertThat(it.hasNext(), is(false));
   }

}