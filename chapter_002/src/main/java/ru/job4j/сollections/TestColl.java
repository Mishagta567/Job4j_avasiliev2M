package ru.job4j.tracker;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public interface Input {
   /**
    *  А зачем здесь модификатор public?  Вроде же интерфейсы все public &
    */
   String ask(String question);
   //String ask();

   int ask(String question, int[] range);
   
}