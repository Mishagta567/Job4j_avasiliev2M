package ru.job4j.condition;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    07.12.2017
 * @version  1.0.0
 */

public class DummyBot {
   /**
    * Отвечает на вопросы.
    * @param question Вопрос от клиента.
    * @return Ответ.
    */
   public String answer(String question) {
       String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
       if ("Привет, Бот".equals(question)) {
          rsl = "Привет, умник.";
       } else if ("Пока".equals(question)) {
          rsl = "До скорой встречи.";
       }
       return rsl;
   }

   /**
    * тестовая часть main если захотим проверить вручную.
    * @param args
    *
   public static void main(String[] args) {
      String testString = "Это тебя поставит в тупик?";
      DummyBot TestBot = new DummyBot();
      System.out.print(TestBot.answer(testString));
   } */
}