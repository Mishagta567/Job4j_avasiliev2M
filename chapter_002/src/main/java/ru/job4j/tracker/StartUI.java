package ru.job4j.tracker;

import ru.job4j.models.*;
// import ru.job4j.models.Tracker;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class StartUI {
   /**
    * Константы меню для добавления новой заявки.
    *   AddItm     - 0 - добавить заявку
    *   Show       - 1 - показать ВСЕ заявки
    *   Edit       - 2 - изменить заявку
    *   Delete     - 3 - удалить заявку
    *   FindByName - 4 - найти по имени
    *   FindByID   - 5 - найти по ID
    *   Exit       - 6 - выйти
    */
   private static final String AddItm        = "0";
   private static final String Show          = "1";
   private static final String Edit          = "2";
   private static final String Delete        = "3";
   private static final String FindByName    = "4";
   private static final String FindByID      = "5";
   private static final String Exit          = "6";

   /**
    * Получение данных от пользователя.
    */
   private final Input input;

   /**
    *    Хранилище заявок.
    */
   private final Tracker tracker;

   /**
    * Конструтор инициализирующий поля.
    * @param input ввод данных.
    * @param tracker хранилище заявок.
    */
   public StartUI(Input input, Tracker tracker) {
      this.input   = input;
      this.tracker = tracker;
   }

   /**
    * Основой цикл программы.
    */
   public void init() {
      boolean exit = false;
      while (!exit) {
         this.showMenu();
         String answer = this.input.ask("Введите пункт меню : ");
         if (AddItm.equals(answer)) {
            //добавление заявки вынесено в отдельный метод.
            this.createItem();
//            } else if (...) {
//             Добавить остальные действия системы по меню.
         } else if (Exit.equals(answer)) {
            exit = true;
         }
      }
   }

   /**
    * Метод реализует добавленяи новый заявки в хранилище.
    */
   private void createItem() {
      System.out.println("------------ Добавление новой языки --------------");
      String name = this.input.ask("Введите имя заявки :");
      String desc = this.input.ask("Введите описание заявки :");
      Item item = new Item(name, desc);
      this.tracker.add(item);
      System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
   }

   private void showMenu() {
      System.out.println("Меню:");
      System.out.println("0 - добавить заявку.");
      System.out.println("1 - показать все заявки.");
      System.out.println("2 - изменить заявку.");
      System.out.println("3 - удалить заявку.");
      System.out.println("4 - найти по имени.");
      System.out.println("5 - найти по ID.");
      System.out.println("6 - выйти.");
   }

   /**
    * Запускт программы.
    * @param args
    */
   public static void main(String[] args) {
      new StartUI(new ConsoleInput(), new Tracker()).init();
   }
   
}