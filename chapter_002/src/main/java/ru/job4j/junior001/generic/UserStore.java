package ru.job4j.junior001.generic;

/**
 * Реализовать Store
 * @author   A_Vasiliev
 * @since    20.01.2018
 * @version  1.0.0
 */


//public class UserStore extends AbstractStore<User> implements Store<User> {
public class UserStore extends AbstractStore<User> {

	/**		Это все НЕ НУЖНО вроде. Для работы достаточно того, что есть в AbstractStore
	private String name;
   private Object[] uStore;
   private int index = 0;  */

   public UserStore(int size) {

		 //  intelJ заставила написать меня след. строчку, но я не понимаю: Разве мы можем вызывать конструктор / создавать объект абстр. класса?
   	super(size);  // Почему не могу сделать AbstractStore(size) ?

   	///uStore = new Object[size];
   }

   /**
   @Override
	public void add(User value) {
         this.uStore[index++] = value;
   }

   @Override
	public boolean update(String id, User value) {
      int position = new Integer(id);
      boolean result = false;
      if (position <= this.index) {
         this.uStore[position] = value;
         result = true;
      }
      return result;
   } //


	@Override
	public boolean delete(String id) {
      int position = new Integer(id);
      boolean result = false;
      if (position <= this.index && position >= 0) {
         for (int loopIndex = position; loopIndex < this.index; loopIndex++) {
            this.uStore[loopIndex++] = this.uStore[loopIndex];  // перемещаем  всю  цепочку справа на лево до ячейки удаления
         }
         uStore[this.index--] = null; // как бы удаляем последний объект и уменьшаем index на 1
         result = true;
      }
      return result;
   } //  */

   public static void main(String[] args) {
		System.out.println("Yo");
		UserStore usr = new UserStore(10);
		usr.add(new User("50"));
		usr.add(new User("51"));
		//System.out.println(usr.uStore[1].toString());
		System.out.println(usr.get("1").getId());


	}


}