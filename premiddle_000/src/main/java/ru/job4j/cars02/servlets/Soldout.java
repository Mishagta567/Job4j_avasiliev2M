package ru.job4j.cars02.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.cars02.AllCarsAds;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Создадим сервлет, который будет дергать UserStore03.
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */
// Import required java libraries

public class Soldout extends HttpServlet {


   @Override
   public void init() {
      // Get the file location where it would be stored.
   }

   @Override
   public void doGet(HttpServletRequest request,  HttpServletResponse response)
           throws ServletException, IOException {
      throw new ServletException("GET method used with " + getClass().getName() + ": POST method required.");
   }   //  */

   /**
    * Upon receiving file upload submission, parses the request to read
    * upload data and saves the file on disk.
    */
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String adId = req.getParameter("adId");
      String newStatus = req.getParameter("status");
      AllCarsAds allCarsAds = new AllCarsAds();
      allCarsAds.setNewStatus(Integer.parseInt(adId), "N");
      getServletContext().getRequestDispatcher("/carsAds.jsp").forward(req, resp);
   }

}