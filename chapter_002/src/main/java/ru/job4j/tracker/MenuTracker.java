package ru.job4j.tracker;

import ru.job4j.models.*;
import ru.job4j.models.Task;    // Почему пришлось импортировать?

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */
class EditItem extends BaseAction {
   public EditItem(int key, String name) {
      super(key, name);
   }
   @Override
   public void execute(Input input, Tracker tracker) {
      String id = input.ask("Task ID to edit ");
      String name = input.ask("Enter the task name: ");
      String desc = input.ask("Enter the description: ");
      Task task = new Task(name, desc);
      task.setId(id);
      tracker.replace(id, task);
   }
}

public class MenuTracker {
   private Input   input;
   private Tracker tracker;
   private static int[]   range = {1, 2, 3, 4, 5, 6, 7, 8};
   private UserAction[] actions = new UserAction[8];
   private int position = 0;

   public MenuTracker(Input input, Tracker tracker) {
      this.input = input;
      this.tracker = tracker;
   }

   public void fillActions() {
      // how to fill it
      this.actions[position] = new AddItem(              position++ + 1, "Add new task");                 // NOT static   this.new AddItem()
      this.actions[position] = new MenuTracker.ShowItems(position++ + 1, "Show all tasks"); //     static
      this.actions[position] = new EditItem(             position++ + 1, "Edit tasks");                  // NOT static  Но Внешний !!!
      this.actions[position] = new MenuTracker.DeleteItem(position++ + 1, "Delete task by ID");    // NOT static
      this.actions[position] = new MenuTracker.FindById( position++ + 1, "Find task by ID");      //     static
      this.actions[position] = new FindByName(           position++ + 1, "Find task by Name");                // NOT static
      this.actions[position] = new LoopExit(             position++ + 1, "Exit");                  // NOT static
   }

   public void addAction(UserAction action) {
      this.actions[position++] = action;
   }

   public int select(int key) {
      this.actions[key].execute(this.input, this.tracker);
      return key;
   }

   public void show() {
      for (UserAction action : this.actions) {
         if (action != null) {
            System.out.println(action.info());
         }
      }
   }

   /** // Сохраним до окончания отладки
   private class AddItemd implements UserAction {
      @Override
      public int key() {
         return 1;
      }
      @Override
      public void execute(Input input, Tracker tracker) {
         String name = input.ask("Enter the task name: ");
         String desc = input.ask("Enter the description: ");
         tracker.add(new Task(name, desc));
      }
      @Override
      public String info() {
         return String.format("%s %s", this.key(), "Add the new Item");
      }
   }     //  */

   public class AddItem extends BaseAction {
      public AddItem(int key, String name) {
         super(key, name);
      }

      @Override
      public void execute(Input input, Tracker tracker) {
         String name = input.ask("Enter name:");
         String desc = input.ask("Enter description:");
         tracker.add(new Item(name, desc));
      }
   }

   private static class ShowItems extends BaseAction {
      public ShowItems(int key, String name) {
         super(key, name);
      }
      @Override
      public void execute(Input input, Tracker tracker) {
         for (Item item : tracker.getAll()) {
            System.out.format("Name: %s, Descr: %s, ID: %s %s", item.getName(), item.getDescription(), item.getId(), System.lineSeparator());
         }
      }
   }

   private class DeleteItem extends BaseAction {
      public DeleteItem(int key, String name) {
         super(key, name);
      }
      @Override
      public void execute(Input input, Tracker tracker) {
         String id = input.ask("Enter the task ID to delete");
         tracker.delete(id);
      }
   }

   private static class FindById extends BaseAction {
      public FindById(int key, String name) {
         super(key, name);
      }
      @Override
      public void execute(Input input, Tracker tracker) {
         String id = input.ask("Enter task ID for search");
         Item itm = tracker.frindById(id);
         //System.out.printf("Name: %$, Descr: %s, ID: %s %s", itm.getName(), itm.getDescription(), itm.getId(), System.lineSeparator());
         System.out.println(String.format("Name: %s, Descr: %s, ID: %s", itm.getName(), itm.getDescription(), itm.getId()));
      }
   }

   private class FindByName extends BaseAction {
      public FindByName(int key, String name) {
         super(key, name);
      }
      @Override
      public void execute(Input input, Tracker tracker) {
         String id = input.ask("Enter the task Name for search");
         Item[] itm = tracker.findByName(id);
         for (int ind = 0; ind < itm.length; ind++) {
            //System.out.printf("Name: %$, Descr: %s, ID: %s %s", itm[ind].getName(), itm[ind].getDescription(), itm[ind].getId(), System.lineSeparator());
            System.out.println(String.format("Name: %s, Descr: %s, ID: %s", itm[ind].getName(), itm[ind].getDescription(), itm[ind].getId()));
         }
      }
   }

   private class LoopExit extends BaseAction {
      public LoopExit(int key, String name) {
         super(key, name);
      }
      @Override
      public void execute(Input input, Tracker tracker) {
         System.out.println("Exit");
      }
   }

   public int[] getRange() {
      return MenuTracker.range;
   }

}