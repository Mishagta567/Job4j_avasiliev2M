package ru.job4j.cars02.models;

public class CarsAdsHeatingDetails {
   private int id;
   //private CarsAds add;
   private CarsAds carsAd;
   private int carsAdId;
   private CarsHeating carsHeating;

   public CarsAdsHeatingDetails() {
   }

   public CarsAdsHeatingDetails(int id) {
      this.id = id;
   }

   //public CarsAdsHeatingDetails(int id, CarsAds adId, CarsHeating carsHeating) {
   public CarsAdsHeatingDetails(int id, CarsAds carsAd, int carsAdId, CarsHeating carsHeating) {
      this.id = id;
      //this.carsAd = carsAd;
      this.carsAdId = carsAdId;
      this.carsHeating = carsHeating;
   }

   public int getCarsAdId() {
      return carsAdId;
   }

   public void setCarsAdId(int carsAdId) {
      this.carsAdId = carsAdId;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public CarsHeating getCarsHeating() {
      return carsHeating;
   }

   public void setCarsHeating(CarsHeating carsHeating) {
      this.carsHeating = carsHeating;
   }
}
