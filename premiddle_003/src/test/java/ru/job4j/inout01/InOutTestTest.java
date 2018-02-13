package ru.job4j.inout01;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class InOutTestTest {

   @Test
   public void inputStreamGiveEvenNumber() throws Exception {
      InputOutput iot = new InputOutput();
      String string = "1256";
      // new byte[] {49, 50, 53, 54}) = 1256
      boolean result = iot.checkNumberFromStream(new ByteArrayInputStream(string.getBytes())); //new byte[] {49, 50, 53, 54}));
      Assert.assertThat(result, Is.is(true));
   }

   @Test
   public void inputStreamGiveNotEvenNumber() throws Exception {
      InputOutput iot = new InputOutput();
      String string = "1257";
      // new byte[] {49, 50, 53, 55}) = 1257
      boolean result = iot.checkNumberFromStream(new ByteArrayInputStream(string.getBytes())); // new byte[] {49, 50, 53, 55}));
      Assert.assertThat(result, Is.is(false));
   }

   @Test
   public void checkRemoveAbuse() throws Exception {
      String[] abuse = {"WWW", "XXX", "@"};
      InputOutput iot = new InputOutput();
      String startString = "In WWW too much XXX and fishing. We have to hide our @";
      InputStream in = new ByteArrayInputStream(startString.getBytes("UTF-8"));

      OutputStream out = new ByteArrayOutputStream();
      iot.dropAbuses(in, out, abuse);
      String expectResult = "In  too much  and fishing. We have to hide our ";
      Assert.assertThat(out.toString(), Is.is(expectResult));
   }

}
