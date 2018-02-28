package ru.job4j.cars02.models;

public class CarsModel {
   private int id;
   private CarsBrand brand;
   private String name;

   public CarsModel() {
   }

   public CarsModel(int id) {
      this.id = id;
   }

   public CarsModel(int id, String name) {
      this.id = id;
      this.name = name;
   }

   public CarsModel(int id, CarsBrand brand, String name) {
      this.id = id;
      this.brand = brand;
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public CarsBrand getBrand() {
      return brand;
   }

   public void setBrand(CarsBrand brand) {
      this.brand = brand;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}
