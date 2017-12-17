package ru.job4j.tracker;

import ru.job4j.models.*;
//import ru.job4j.tracker.Tracker;

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
    *   ADD     - 0 - добавить заявку
    *   Show       - 1 - показать ВСЕ заявки
    *   Edit       - 2 - изменить заявку
    *   Delete     - 3 - удалить заявку
    *   FindByName - 4 - найти по имени
    *   FindByID   - 5 - найти по ID
    *   EXIT       - 6 - выйти
    */
   private static final String ADD           = "0";
   private static final String SHOW          = "1";
   private static final String EDIT          = "2";
   private static final String DELETE        = "3";
   private static final String FINDBYNAME    = "4";
   private static final String FINDBYID      = "5";
   private static final String EXIT = "6";
   private static boolean runTest = false;

   /**
    * Получение данных от пользователя.
    */
   private final Input input;
   public StubInput stInput;

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
         if (ADD.equals(answer)) {
            //добавление заявки
            this.createItem();
         } else if (SHOW.equals(answer)) {
            // Вывод всех заявок
            this.showAll();
         } else if (EDIT.equals(answer)) {
            this.replaceItem();
         } else if (DELETE.equals(answer)) {
            this.deleteItem();
         } else if (FINDBYNAME.equals(answer)) {
            this.findByName();
         } else if (FINDBYID.equals(answer)) {
            this.findById();
         } else if (EXIT.equals(answer)) {
            exit = true;
         }
      }
   }

   /**
    * Метод реализует добавленяи новый заявки в хранилище.
    */
   private void createItem() {
      System.out.println("------------ Add new task --------------");
      String name = this.input.ask("Task name: ");
      String desc = this.input.ask("Task description: ");
      Item item = new Item(name, desc);
      this.tracker.add(item);
      System.out.println("------------ New task c getId : " + item.getId() + "-----------");
   }

   private void replaceItem() {
      System.out.println("------------ Replace task BY ID ------------");
      String name = this.input.ask("Task name: ");
      String desc = this.input.ask("Task description: ");
      String id   = this.input.ask("Task ID: ");
      Item item = new Item(name, desc);
      if (this.tracker.replace(id, item)) {
         System.out.println("----- Task with getId= " + item.getId() + " changed. ----");
      } else {
         System.out.println("--- Task with getId= " + item.getId() + " NOT FOUND. --");
      }

      //this.tracker.add(Item0);

   }

   private void deleteItem() {
      System.out.println("----------- Delete task BY ID -----------");
      String id   = this.input.ask("Task ID: ");
      if (this.tracker.delete(id)) {
         System.out.println("----- Task with getId : " + id + " deleted -----");
      } else {
         System.out.println("----- Task with getId : " + id + " NOT FOUND ---");
      }
   }

   private void findByName() {
      System.out.println("--------- Task search BY NAME ---------");
      String name = this.input.ask("Task name: ");
      Item[] findItem = this.tracker.findByName(name);
      System.out.println("-- Tasks with name: " + name + " --");
      if (findItem.length > 0) {
         for (int ind = 0; ind < findItem.length; ind++) {
            System.out.printf("Task: %s %S", findItem[ind].getName(), findItem[ind].getDescription());
            System.out.println(" ");
         }
      } else {
         System.out.printf("No tasks with name %s", name);
      }
   }

   private void findById() {
      System.out.println("---------- Task search BY ID ------------");
      String id = this.input.ask("Task ID: ");
      Item findItem = this.tracker.frindById(id);
      System.out.println("------ Tasks with ID: " + id + " ------");
      System.out.printf("Task Name: %s, description: %s", findItem.getName(), findItem.getDescription());
      System.out.println(" ");
   }

   private void showAll() {
      for (Item itm : this.tracker.getAll()) {
         System.out.printf("%s, %s, %s, %s", itm.getName(), itm.getDescription(), itm.getId(), System.lineSeparator());
      }
   }

   private void showMenu() {
      System.out.println("Menu:");
      System.out.println("0 - add task.");
      System.out.println("1 - show all tasks.");
      System.out.println("2 - change tasks.");
      System.out.println("3 - delete0 tasks.");
      System.out.println("4 - find by name.");
      System.out.println("5 - fidn by ID.");
      System.out.println("6 - exit.");
   }

   // set и get для
   public void setRunTest(boolean ind) {
      this.runTest = ind;
   }

   /**
    * Запускт программы.
    * @param args bla bla bla
    */
   public static void main(String[] args) {
      new StartUI(new ConsoleInput(), new Tracker()).init();
      //System.out.println("1-2-3");
   }

}