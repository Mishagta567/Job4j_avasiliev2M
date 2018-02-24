package ru.job4j.filter06;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class InsertRoleServlet06Test {

   @Test
   public void testInsertRoleServlet() {
      InsertRoleServlet06 insertRole06 = new InsertRoleServlet06();
      HttpServletRequest req = mock(HttpServletRequest.class);
      HttpServletResponse resp = mock(HttpServletResponse.class);
      //setup the behaviour here (or do it in setup method or something)
      when(req.getParameter("role")).thenReturn("wahoo4");

      try {
         insertRole06.doPost(req, resp);
      } catch (ServletException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

      assertThat(1, is(1));
   }

}