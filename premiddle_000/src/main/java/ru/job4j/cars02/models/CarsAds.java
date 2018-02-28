package ru.job4j.cars02.models;

import java.sql.Timestamp;
import java.util.List;

public class CarsAds {
   private int id;
   private CarsBrand carsBrand;
   private CarsModel carsModel;
   private CarsBodyType carsBodyType;
   private CarsTransmission carsTransmission;
   private CarsEngineType carsEngineType;
   private CarsDriveUnit carsDriveUnit;
   private int userId;
   private int mileage;
   private String description;
   private Timestamp insertedDate;
   private int photoId = 0;
   private String status = "Y";
   private List<CarsPhotos> carsPhotoslist;
   private List<CarsAdsHeatingDetails> carsAdsHeatingDetails;

   public CarsAds() {
   }

   public CarsAds(int id, CarsBrand carsBrand, CarsModel carsModel, CarsBodyType carsBodyType, CarsTransmission carsTransmission,
                  CarsEngineType carsEngineType, CarsDriveUnit carsDriveUnit, int mileage, String description) {
      this.id = id;
      this.carsBrand = carsBrand;
      this.carsModel = carsModel;
      this.carsBodyType = carsBodyType;
      this.carsTransmission = carsTransmission;
      this.carsEngineType = carsEngineType;
      this.carsDriveUnit = carsDriveUnit;
      this.mileage = mileage;
      this.description = description;
      this.insertedDate = new Timestamp(System.currentTimeMillis());
   }

   public int getPhotoId() {
      return photoId;
   }

   public void setPhotoId(int photoId) {
      this.photoId = photoId;
   }

   public List<CarsPhotos> getCarsPhotoslist() {
      return carsPhotoslist;
   }

   public void setCarsPhotoslist(List<CarsPhotos> carsPhotoslist) {
      this.carsPhotoslist = carsPhotoslist;
   }

   public List<CarsAdsHeatingDetails> getCarsAdsHeatingDetails() {
      return carsAdsHeatingDetails;
   }

   public void setCarsAdsHeatingDetails(List<CarsAdsHeatingDetails> carsAdsHeatingDetails) {
      this.carsAdsHeatingDetails = carsAdsHeatingDetails;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public CarsBrand getCarsBrand() {
      return carsBrand;
   }

   public void setCarsBrand(CarsBrand carsBrand) {
      this.carsBrand = carsBrand;
   }

   public CarsModel getCarsModel() {
      return carsModel;
   }

   public void setCarsModel(CarsModel carsModel) {
      this.carsModel = carsModel;
   }

   public CarsBodyType getCarsBodyType() {
      return carsBodyType;
   }

   public void setCarsBodyType(CarsBodyType carsBodyType) {
      this.carsBodyType = carsBodyType;
   }

   public CarsTransmission getCarsTransmission() {
      return carsTransmission;
   }

   public void setCarsTransmission(CarsTransmission carsTransmission) {
      this.carsTransmission = carsTransmission;
   }

   public CarsEngineType getCarsEngineType() {
      return carsEngineType;
   }

   public void setCarsEngineType(CarsEngineType carsEngineType) {
      this.carsEngineType = carsEngineType;
   }

   public CarsDriveUnit getCarsDriveUnit() {
      return carsDriveUnit;
   }

   public void setCarsDriveUnit(CarsDriveUnit carsDriveUnit) {
      this.carsDriveUnit = carsDriveUnit;
   }

   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public int getMileage() {
      return mileage;
   }

   public void setMileage(int mileage) {
      this.mileage = mileage;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Timestamp getInsertedDate() {
      return insertedDate;
   }

   public void setInsertedDate(Timestamp insertedDate) {
      this.insertedDate = insertedDate;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

}
