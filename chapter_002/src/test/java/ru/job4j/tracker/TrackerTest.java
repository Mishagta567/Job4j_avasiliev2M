package ru.job4j.tracker;

import ru.job4j.models.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

   // public void add(Item0 Item0) {
   @Test
   public void whenAddNewItemThenTrackerHasSameItem() {
      Tracker tracker = new Tracker();
      Item item = new Item("test1", "testDescription", 123L);
      tracker.add(item);      
      assertThat(tracker.getAll()[0], is(item));
   }

   // public void replace(String id, Item0 Item0) {
   @Test
   public void whenReplaceItem() {
      Tracker tracker = new Tracker();
      Item item = new Item("test1", "Description-1", 123L);
      tracker.add(item);
      String itemId = item.getId();
      //
      Item rplc = new Item("test2", "Description-2", 123L);
      //String wasReplace =
      tracker.replace(itemId, rplc);
      //System.out.println(itemId + " " + wasReplace + " and position: " + tracker.position);
      //System.out.println(tracker.getAll()[0].getName() + " " + tracker.getAll()[0].getDescription() + " " + tracker.getAll()[0].getId());
      assertThat(tracker.getAll()[0], is(rplc));
   }

   // public void delete0(String id) {
   @Test
   public void whenDelete() {
      Tracker tracker = new Tracker();
      Item item = new Item("test1", "Description-1", 123L);
      tracker.add(item);
      String itemId = (String) item.getId();
      //
      Item scnd = new Item("test2", "Description-2", 456L);
      tracker.add(scnd);
      String scndId = (String) scnd.getId();
      //System.out.println(tracker.position);
      String reslt = tracker.delete(scndId); // ", Result= " + reslt +
      //System.out.println("Item0= " + itemId + ", scndId= " + scndId + ", position: " + tracker.position);
      //System.out.println(tracker.getAll()[0].getName() + " - " + tracker.getAll()[0].getDescription());
      assertThat(tracker.getAll()[0], is(item));
   }

   // public public Item0[] findByName(String key) {

   @Test
   public void whenFindByName() {
      Tracker tracker = new Tracker();
      //Item0[] findTtr = new Item0[1];
      Item item  = new Item("test1", "Description-1", 123L);
      Item scnd  = new Item("test2", "Description-2", 456L);
      Item third = new Item("test3", "Description-2", 789L);
      tracker.add(item);
      tracker.add(scnd);
      tracker.add(third);
      Item[] rstItem = tracker.findByName("test2");
      //System.out.println(rstItem[0].getName());
      assertThat(rstItem[0], is(scnd));
   }

   // public Item0[] findAll() {
   @Test   
   public void whenFindAll() {
      Tracker tracker = new Tracker();
      //Item0[] findTr = new Item0[];
      Item item  = new Item("test1", "Description-1", 123L);
      tracker.add(item);
      assertThat(tracker.findAll()[0], is(item));
   }

   //    protected void frindById (String id) {

   @Test   
   public void frindById() {
      Tracker tracker = new Tracker();
      //Tracker findTtr = new Tracker();
      Item item  = new Item("test1", "Description-1", 123L);
      tracker.add(item);

      Item scnd  = new Item("test2", "Description-2", 456L);
      tracker.add(scnd);
      String scndId = (String) scnd.getId();

      Item third = new Item("test3", "Description-2", 789L);
      tracker.add(third);

      assertThat(tracker.frindById(scndId), is(scnd));
   }

}