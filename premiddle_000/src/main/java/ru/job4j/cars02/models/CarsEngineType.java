package ru.job4j.cars02.models;

public class CarsEngineType {
   private int id;
   private String name;

   public CarsEngineType() {
   }

   public CarsEngineType(int id) {
      this.id = id;
   }

   public CarsEngineType(int id, String name) {
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
