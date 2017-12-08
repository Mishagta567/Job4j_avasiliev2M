package ru.job4j.condition;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    05.12.2017
 * @version  1.0.0
 */

public class PointWrong {
   private int pX;
   private int pY;
   /**
   * main просто выводит почти стандартную фразу
   * В main мы должны инициализировать две точки и вычислить расстояние между ними
   */
   // Видимо это конструктор для инициализации значения pX и pY
   public PointWrong(int x, int y) {
      this.pX = x;
      this.pY = y;
   }
   // Вычслим расстояние между точками:
   public double findDistanse(PointWrong a1, PointWrong b1) {
      //double result = 9.01D;
      return Math.sqrt(Math.pow((a1.pX - b1.pX), 2) + Math.pow((a1.pY - b1.pY), 2));
      //return result;
   }

   public static void main(String[] args) {
      PointWrong aa = new PointWrong(1, 1);
      PointWrong bb = new PointWrong(1, 4);
      //double dist = A.findDistanse(A, B);
      System.out.print(aa.findDistanse(aa, bb));
   }
}