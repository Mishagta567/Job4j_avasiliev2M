package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
   // получаем ссылку на стандартный вывод в консоль.
   PrintStream stdout = System.out;
   // Создаем буфур для хранения вывода.
   ByteArrayOutputStream out = new ByteArrayOutputStream();

   @Before
   public void loadOutput() {
      System.out.println("execute before method");
      System.setOut(new PrintStream(this.out));
   }

   @After
   public void backOutput() {
      System.setOut(this.stdout);
      System.out.println("execute after method");
   }

   @Test
   public void whenDrawMain() {

      //Заменяем стандартный вывод на вывод в пямять для тестирования.
      //System.setOut(new PrintStream(out));
      // выполняем действия пишушиее в консоль.
      new Paint().draw(new Square());
      new Paint().draw(new Triangle());
      // проверяем результат вычисления

      StringBuilder pic = new StringBuilder();
      //pic.append("Квадрат:");
      //pic.append(ln);
      String ln = System.lineSeparator();
      pic.append("++++");
      pic.append(ln);
      pic.append("+  +");
      pic.append(ln);
      pic.append("+  +");
      pic.append(ln);
      pic.append("++++");
      pic.append(ln);

      pic.append("   +   ");
      pic.append(ln);
      pic.append("  ***  ");
      pic.append(ln);
      pic.append(" ***** ");
      pic.append(ln);
      pic.append("*******");
      pic.append(ln);
      String result = pic.toString();

      assertThat( new String(out.toByteArray()), is(result));
      // возвращаем обратно стандартный вывод в консоль.
      //System.setOut(stdout);
   }

   @Test
   public void whenDrawSquare() {

       //System.setOut(new PrintStream(out));
       new Paint().draw(new Square());
       assertThat(
            new String(out.toByteArray()),
            is(
                 new StringBuilder()
                     .append("++++")
                     .append(System.lineSeparator())
                     .append("+  +")
                     .append(System.lineSeparator())
                     .append("+  +")
                     .append(System.lineSeparator())
                     .append("++++")
                     .append(System.lineSeparator())
                     .toString()
            )
      );
      //System.setOut(stdout);
   }

   @Test
   public void whenDrawTriangle() {

      //System.setOut(new PrintStream(out));
      new Paint().draw(new Triangle());
      assertThat(
         new String(out.toByteArray()),
         is(
            new StringBuilder()
               .append("   +   ")
               .append(System.lineSeparator())
               .append("  ***  ")
               .append(System.lineSeparator())
               .append(" ***** ")
               .append(System.lineSeparator())
               .append("*******")
               .append(System.lineSeparator())
               .toString()
             )
       );
       //System.setOut(stdout);
   }
}