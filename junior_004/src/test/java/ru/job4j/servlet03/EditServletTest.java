package ru.job4j.servlet03;

import org.junit.Test;
import ru.job4j.mvc05.UsersController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class EditServletTest {
   @Test
   public void doGet() throws Exception {
   }

   @Test
   public void doPostCheck() throws SerialException, IOException {
      UsersController controller = new UsersController();
      HttpServletRequest request = mock(HttpServletRequest.class);
      HttpServletResponse response = mock(HttpServletResponse.class);

      //controller.doPost(request, response);

   }

}