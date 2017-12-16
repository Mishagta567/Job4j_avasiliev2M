package ru.job4j.pseudo;

public class Paint {

   public void draw(Shape shape) {
      System.out.print(shape.draw());
   }

   public static void main(String[] args) {
      Context context = new Context(new Square());
      //System.out.println("Квадрат:");
      System.out.print(context.executeStrategy());

      //System.out.println("Треугольник:");
      context = new Context(new Triangle());
      System.out.println(context.executeStrategy());
   }

}