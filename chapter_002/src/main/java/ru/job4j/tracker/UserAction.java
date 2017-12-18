package ru.job4j.tracker;

//import ru.job4j.models.item;
//import ru.job4j.models.Task0;
// import ru.job4j.models.Tracker;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public interface UserAction {
   /**
    * Класс для симуляции действий пользователя.
    */
   // Ключ того действия, который хочет выполнить пользователь.
   int key();

   // Выполнение основных действий
   void execute(Input input, Tracker tracker);

   // Что делает данный метод
   String info();
}