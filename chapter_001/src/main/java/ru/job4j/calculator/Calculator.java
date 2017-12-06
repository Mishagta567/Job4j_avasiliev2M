package ru.job4j.calculator;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    06.12.2017
 * @version  1.0.0
 */

public class Calculator {
    private double result;

    // Метод для сложения
    public void add(double first, double second) {
       this.result = first + second;
    }
    // Метод для вычитания
    public void deduct(double first, double second) {
       this.result = first - second;
    }
    // Метод для умножения
    public void multiply(double first, double second) {
       this.result = first * second;
    }
    // Метод для деления
    public void divide(double first, double second) {
       this.result = first / second;
    }

   public double getResult() {
      return this.result;
   }
}