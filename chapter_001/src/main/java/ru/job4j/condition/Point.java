package ru.job4j.condition;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    05.12.2017
 * @version  1.0.0
 */

public class Point {
   private int pX;
   private int pY;
   /**
   * main просто выводит почти стандартную фразу
   * В main мы должны инициализировать две точки и вычислить расстояние между ними
   */
   // Видимо это конструктор для инициализации значения pX и pY
   public Point(int x, int y) {
      this.pX = x;
      this.pY = y;
      // System.out.println("From constructor: this.x = " + this.pX);
      // System.out.println("From constructor: this.y = " + this.pY);
   }
   // Вычслим расстояние между точками:
   public double distanceTo(Point that) {
      // Точка А - это текущая точка. К ней мы обращаемся через оператор this.
      // Точка В - это входящая точка. К ней мы можем обратиться напрямую через имя переменной that.
      // сделаем вывод на консоль.
      System.out.println("distTo: this.x = " + this.pX);
      System.out.println("distTo: this.y = " + this.pY);
      System.out.println("distTo: that.x = " + that.pX);
      System.out.println("distTo: that.y = " + that.pY);
      return Math.sqrt(
            Math.pow(this.pX - that.pX, 2) + Math.pow(this.pY - that.pY, 2)
      );
   }

   public static void main(String[] args) {
      Point a = new Point(1, 2);
      Point b = new Point(3, 4);
      // сделаем вызов метода
      //System.out.println("main: x1 = " + a.pX);
      //System.out.println("main: y1 = " + a.pY);
      //System.out.println("main: x2 = " + b.pX);
      //System.out.println("main: y2 = " + b.pY);

      double result = a.distanceTo(b);
      System.out.println("Расстояние между точками А и В : " + result);
      // Насколько я понял - this относится к тому классу, из которого вызывается метод. Если вызовем из b
      result = b.distanceTo(a);
      System.out.println("Расстояние между точками А и В : " + result);
   }
}