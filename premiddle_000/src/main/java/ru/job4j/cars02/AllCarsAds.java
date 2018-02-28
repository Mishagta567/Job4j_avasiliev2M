package ru.job4j.cars02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.job4j.cars02.models.*;

import java.util.List;

public class AllCarsAds {
   SessionFactory factory;
   Session session;

   public AllCarsAds() {
      openSeesion();
   }

   public List<CarsAds> getAllAds() {
      Query query = session.createQuery("from CarsAds WHERE status <> :paramStatus");
      query.setParameter("paramStatus", "N");
      List<CarsAds> allCarsAds = query.list();  //session.createQuery("from CarsAds").list();
      return allCarsAds;
   }

   public int getLogin(String login, String password) {
      int result = 0;
      Query query = session.createQuery("from User02 WHERE login = :paramLogin");
      query.setParameter("paramLogin", login);
      List<User02> allUsers02 = query.list();
      for (User02 user : allUsers02) {
         if (user.getPassword().equals(password)) {
            result = user.getId();
            break;
         }
      }
      return result;
   }

   public CarsAds getCarAd(int carAdId) {
      // Query query = session.createQuery("from CarsAds WHERE id = :paramAdId");
      // query.setParameter("paramAdId", carAdId);
      CarsAds carAd = session.get(CarsAds.class, carAdId);
      return carAd;
   }

   public int newPhoto(int carAdId) {
      // Query query = session.createQuery("from CarsAds WHERE id = :paramAdId");
      // query.setParameter("paramAdId", carAdId);
      CarsAds carAd = session.get(CarsAds.class, carAdId);
      CarsPhotos carsPhoto = new CarsPhotos();
      carsPhoto.setCarsAds(carAd);
      session.save(carsPhoto);
//      session.getTransaction().commit();
      if (carAd.getPhotoId() == 0) {
         carAd.setPhotoId(carsPhoto.getPhotoId());
         session.save(carAd);
      }
      session.getTransaction().commit();
      int result = carsPhoto.getPhotoId();
      //closeSeesion();
      return result;
   }

   public List<CarsAdsHeatingDetails> getAllHeatingDetails(int addId) {
      Query query = session.createQuery("from CarsAdsHeatingDetails WHERE carsAdId = :paramAdId");
      query.setParameter("paramAdId", addId);
      List<CarsAdsHeatingDetails> heatingDetails = query.list();
      return heatingDetails;
   }

   public List<CarsPhotos> getAllAdPhotos(int addId) {
      CarsAds carAd = session.get(CarsAds.class, addId);
      List<CarsPhotos> heatingDetails = carAd.getCarsPhotoslist();
      return heatingDetails;
   }

   public void setNewStatus(int addId, String newStatus) {
      CarsAds carAd = session.get(CarsAds.class, addId);
      if (!carAd.getStatus().equals(newStatus)) {
         carAd.setStatus(newStatus);
         session.save(carAd);
         session.getTransaction().commit();
      }
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
