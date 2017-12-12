package ru.job4j.condition;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    07.12.2017
 * @version  1.0.0
 */

public class Triangle {
   private Point a;
   private Point b;
   private Point c;

   // Какой-то конструктор. Видимо для инициализации класса при необходимости.
   public Triangle(Point a, Point b, Point c) {
      this.a = a;
      this.b = b;
      this.c = c;
   }

   //Метод должен вычислять расстояние между точками left и right.
   public double distance(Point left, Point right) {
      return left.distanceTo(right);
   }

   /**
    * Метод вычисления периметра по длинам сторон.
    * Формула.
    * (ab + ac + bc) / 2
    *
    * @param ab расстояние между точками a b
    * @param ac расстояние между точками a c
    * @param bc расстояние между точками b c
    * @return Перимент.
    */
   public double period(double ab, double ac, double bc) {
      return (ab + ac + bc) / 2;
   }

   /**
    * Метод должен вычислить прощадь треугольканива.
    * Формула.
    * √ p *(p - ab) * (p - ac) * (p - bc)
    *
    * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
    * @return Вернуть прощадь, если треугольник существует или -1.
    */
   public double area() {
      double rsl = -1;
      double ab = this.distance(this.a, this.b);
      double ac = this.distance(this.a, this.c);
      double bc = this.distance(this.b, this.c);
      double p = this.period(ab, ac, bc);
      if (this.exist(ab, ac, bc)) {
         // написать формулу для расчета площади треугольника.
         rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
      }
      return rsl;
   }

   /**
    * Метод проверяет можно ли построить треугольник с такими длинами сторон.
    *
    * 1) Длины должны быть больше 0
    * 2) сумма любых двух длин НЕ должна быть равна третьей. Это значит что они на одной прямой.
    *
    * @param ab Длина от точки a b.
    * @param ac Длина от точки a c.
    * @param bc Длина от точки b c.
    * @return
    */
   private boolean exist(double ab, double ac, double bc) {
      boolean rst = true;
      if      (ab == 0 || ac == 0 || bc == 0) {
         rst = false;
      } else if ((ab + ac) <= bc)  {
         rst = false;
      } else if (ab >= (ac + bc))  {
         rst = false;
      } else if ((ab + bc) <= ac)  {
         rst = false;
      } else                       {
         rst = true;
      }
      return rst;
   }
}