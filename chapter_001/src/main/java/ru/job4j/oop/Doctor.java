package ru.job4j.oop;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class Doctor extends Profession {
   /**
    * Сделаем метод Лечение ВСЕХ
    */
   public void healTeacher(Teacher ppl) {
      System.out.println(this.getName() + " лечит у больного " + ppl.getName() + " болезнь " + ppl.diseaseName + " за " + this.getSalary() + " $/час");
   }
}

