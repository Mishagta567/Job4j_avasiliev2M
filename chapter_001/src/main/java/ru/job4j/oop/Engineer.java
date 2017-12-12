package ru.job4j.oop;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class Engineer extends Profession {
   /**
    * Сделаем метод Лечение ВСЕХ
    */
   public void prosuceToTeacher(Profession ppl) {
      System.out.println(this.getName() + " делает для учителя " + ppl.getName() + " указку за " + this.getSalary() + " $/час");
   }
   // Мед оборудование отвественней, сложнее и дороже.
   public void prosuceToDoctor(Profession ppl) {
      System.out.println(this.getName() + " делает для дантиста " + ppl.getName() + " указку за " + (this.getSalary() * 5) + " $/час");
   }
}