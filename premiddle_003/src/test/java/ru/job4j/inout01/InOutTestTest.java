package ru.job4j.inout01;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class InOutTestTest {

   @Test
   public void inputStreamGiveEvenNumber() throws Exception {
      InputOutput iot = new InputOutput();
      // new byte[] {49, 50, 53, 54}) = 1256
      boolean result = iot.checkNumberFromStream(new ByteArrayInputStream(new byte[] {49, 50, 53, 54}));
      Assert.assertThat(result, Is.is(true));
   }

   @Test
   public void inputStreamGiveNotEvenNumber() throws Exception {
      InputOutput iot = new InputOutput();
      // new byte[] {49, 50, 53, 55}) = 1257
      boolean result = iot.checkNumberFromStream(new ByteArrayInputStream(new byte[] {49, 50, 53, 55}));
      Assert.assertThat(result, Is.is(false));
   }
}
