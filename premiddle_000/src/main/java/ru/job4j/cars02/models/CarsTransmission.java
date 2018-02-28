package ru.job4j.cars02.models;

public class CarsTransmission {
   private int id;
   private String name;

   public CarsTransmission() {
   }

   public CarsTransmission(int id) {
      this.id = id;
   }

   public CarsTransmission(int id, String name) {
      this.id = id;
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
