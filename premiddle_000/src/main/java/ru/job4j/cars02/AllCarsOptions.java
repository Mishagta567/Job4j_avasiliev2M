package ru.job4j.cars02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.job4j.cars02.models.*;

import java.util.List;

public class AllCarsOptions {
   SessionFactory factory;
   Session session;

   public AllCarsOptions() {
      openSeesion();
   }

   public List<CarsBodyType> getCarsBodyType() {
      Query query = session.createQuery("from CarsBodyType");
      List<CarsBodyType> allBodyTypes = query.list();
      return allBodyTypes;
   }

   public List<CarsBrand> getCarsBrand() {
      Query query = session.createQuery("from CarsBrand ");
      List<CarsBrand> allCarsBrands = query.list();
      return allCarsBrands;
   }

   public List<CarsDriveUnit> getCarsDriveUnit() {
      Query query = session.createQuery("from CarsDriveUnit ");
      List<CarsDriveUnit> allCarsDriveUnits = query.list();
      return allCarsDriveUnits;
   }

   public List<CarsEngineType> getCarsEngineType() {
      Query query = session.createQuery("from CarsEngineType");
      List<CarsEngineType> allCarsEngineTypes = query.list();
      return allCarsEngineTypes;
   }

   public List<CarsHeating> getCarsHeating() {
      Query query = session.createQuery("from CarsHeating");
      List<CarsHeating> allCarsHeatings = query.list();
      return allCarsHeatings;
   }

   public List<CarsModel> getCarsModel() {
      Query query = session.createQuery("from CarsModel");
      List<CarsModel> allCarsModels = query.list();
      return allCarsModels;
   }

   public List<CarsTransmission> getCarsTransmission() {
      Query query = session.createQuery("from CarsTransmission");
      List<CarsTransmission> allCarsTransmissions = query.list();
      return allCarsTransmissions;
   }

   public void openSeesion() {
      this.factory = new Configuration()
              .configure() // configure setting from hibernate,cfg,xml
              .buildSessionFactory();
      this.session = factory.openSession();
      session.beginTransaction();
   }

   public void closeSeesion() {
      this.session.getTransaction().commit();
      this.session.close();
      this.factory.close();
   }

}
