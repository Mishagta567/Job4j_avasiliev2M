package ru.job4j.oop;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class Teacher extends Profession {
   /**
    * Сделаем метод Лечение ВСЕХ
    */
   public void teachPeople(Engineer eng) {
      System.out.println(this.getName() + " учит " + eng.getName() + " за " + this.getSalary() + " $/час");
   }
   // Учить врачей сложнее и отвественнее. С них возьмем больше
   public void teachDoctor(Doctor dctr) {
      System.out.println(this.getName() + " учит " + dctr.getName() + " за " + (this.getSalary() * 2) + " $/час");
   }
}

