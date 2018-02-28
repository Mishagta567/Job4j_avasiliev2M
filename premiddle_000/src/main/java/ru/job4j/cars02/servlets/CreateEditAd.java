package ru.job4j.cars02.servlets;

import ru.job4j.cars02.models.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.sql.SQLException;


/**
 * Создадим сервлет, который будет дергать UserStore03.
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class CreateEditAd extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      req.getRequestDispatcher("/WEB-INF/views/cars02/createNewAd.jsp?out=get").forward(req, resp);  // Пашет
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       SessionFactory factory = new Configuration()
               .configure() // configure setting from hibernate,cfg,xml
               .buildSessionFactory();
      HttpSession servSession = req.getSession();
      synchronized (servSession) {
         Integer userId = (Integer) servSession.getAttribute("userid");
         Session session = factory.openSession();
         session.beginTransaction();
         CarsAds newAd = new CarsAds();
         newAd.setUserId(userId);
         newAd.setCarsBrand(new CarsBrand(Integer.parseInt(req.getParameter("brand"))));
         newAd.setCarsModel(new CarsModel(Integer.parseInt(req.getParameter("model"))));
         newAd.setCarsBodyType(new CarsBodyType(Integer.parseInt(req.getParameter("bodyType"))));
         newAd.setCarsTransmission(new CarsTransmission(Integer.parseInt(req.getParameter("transmission"))));
         newAd.setCarsEngineType(new CarsEngineType(Integer.parseInt(req.getParameter("engineType"))));
         newAd.setCarsDriveUnit(new CarsDriveUnit(Integer.parseInt(req.getParameter("driveUnit"))));
         newAd.setMileage(Integer.parseInt(req.getParameter("mileage")));
         newAd.setDescription(req.getParameter("description"));

         session.save(newAd);
         session.getTransaction().commit();
         session.close();
         factory.close();
         //req.getRequestDispatcher("/WEB-INF/filter06/userList.jsp?out_get=UserController_Signed").forward(req, resp);  // Пашет
         req.getRequestDispatcher("/carsAds.jsp").forward(req, resp);  // */
      }
   }

}

