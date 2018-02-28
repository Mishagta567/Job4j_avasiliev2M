package ru.job4j.cars02.models;

import java.sql.Timestamp;
import java.util.List;

public class CarsPhotos {
   private int photoId;
   private CarsAds carsAds;

   public CarsPhotos() {
   }

   public CarsPhotos(int photoId) {
       this.photoId = photoId;
   }

   public CarsPhotos(int photoId, CarsAds carsAds) {
      this.photoId = photoId;
      this.carsAds = carsAds;
   }

   public int getPhotoId() {
      return photoId;
   }

   public void setPhotoId(int photoId) {
      this.photoId = photoId;
   }

   public CarsAds getCarsAds() {
      return carsAds;
   }

   public void setCarsAds(CarsAds carsAds) {
      this.carsAds = carsAds;
   }

   @Override
   public String toString() {
      return String.format("ID: %s, photo_id: ", photoId); // , carsAds.getId()); // Протестить, добавить позже.
   }
}
