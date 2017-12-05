package ru.job4j;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    06.12.2017
 * @version  1.2 - тестирование
 */

public class CalculateTest {      
   /**
    * main просто выводит почти стандартную фразу
    * "World, Hello again"
    */
   
   public static void main(String[] args) {      
      System.out.println("World, Hello again");
   }
   
   /**
     * Method Для тестирования echo.
     * @param Александр Васильев
     * @return "Echo, echo, echo : Petr Arsentev".
     *
     */   
   public void whenTakeNameThenTreeEchoPlusName() {
      String input = "Petr Arsentev";
      String expect = "Echo, echo, echo : Petr Arsentev"; 
      Calculate calc = new Calculate();
      String result = calc.echo(input);
      assertThat(result, is(expect));
   }
   
   /**
     * Method echo.     
     */
    public String echo(String name) {
        return "E, e, e: " + name;
    }
   
}