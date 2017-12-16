package ru.job4j.pseudo;

public class Context {
   private Shape shp;

   public Context(Shape shape) {
      this.shp = shape;
   }

   public String executeStrategy() {
      return shp.draw();
   }
}
