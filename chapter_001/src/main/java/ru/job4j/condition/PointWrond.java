package ru.job4j.condition;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    05.12.2017
 * @version  1.0.0
 */

public class PointWrond {
   private int pX;
   private int pY;
   /**
   * main просто выводит почти стандартную фразу
   * В main мы должны инициализировать две точки и вычислить расстояние между ними
   */
   // Видимо это конструктор для инициализации значения pX и pY
   public PointWrond(int x, int y) {
      this.pX = x;
      this.pY = y;
   }
   // Вычслим расстояние между точками:
   public double findDistanse(PointWrond A1, PointWrond B1) {
      //double result = 9.01D;
      return Math.sqrt(Math.pow((A1.pX - B1.pX), 2) + Math.pow((A1.pY - B1.pY), 2 ));
      //return result;
   }

   public static void main(String[] args) {
      PointWrond A = new PointWrond(1, 1);
      PointWrond B = new PointWrond(1, 4);
      //double dist = A.findDistanse(A, B);
      System.out.print(A.findDistanse(A, B));
   }
}