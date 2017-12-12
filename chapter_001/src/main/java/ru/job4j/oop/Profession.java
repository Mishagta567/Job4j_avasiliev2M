package ru.job4j.oop;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class Profession extends Diagnosis {
   /**
    * Нарисуем псевдо доску    *
    */
   private String name;
   private int age, experience, salary, insurance;

   public void setVariable(String nm, int ag, int exp, int slr, int insr) {
      this.name = nm;
      this.age  = ag;
      this.experience = exp;
      this.salary = slr;
      this.insurance = insr;
   }

   // по хорошему у каждого профессионала должны быть (Имя, возраст, опыт, ставка, страховка)
   public Profession(String nm, int ag, int exp, int slr, int insr) {
      setVariable(nm, ag, exp, slr, insr);
   }
   // Сделаем констуктор по умолчанию с не очень разумными значениями для привлечения внимания.
   public Profession() {
      this.setVariable("Ч.Л.", 111, 0, 1, 0);
      //
   }
   // теперь пакеты для того что бы доставать значения переменных:
   public String getName() {
      return name;
   }
   public int getAge() {
      return age;
   }
   public int getExperience() {
      return experience;
   }
   public int getSalary() {
      return salary;
   }
   public int getInsurance() {
      return insurance;
   }
   // Диагноз может быть абсолютно у всех, так что мы его вставляем в родительский класс.
   // Наверное можно было бы унаследовать, но кажется можно делать внутренний класс
}

