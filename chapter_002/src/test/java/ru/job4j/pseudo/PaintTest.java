package ru.job4j.pseudo;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
   @Test
   public void whenDrawMain() {
      // получаем ссылку на стандартный вывод в консоль.
      PrintStream stdout = System.out;
      // Создаем буфур для хранения вывода.
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      //Заменяем стандартный вывод на вывод в пямять для тестирования.
      System.setOut(new PrintStream(out));
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
      System.setOut(stdout);
   }

   @Test
   public void whenDrawSquare() {
       PrintStream stdout = System.out;
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       System.setOut(new PrintStream(out));
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
      System.setOut(stdout);
   }

   @Test
   public void whenDrawTriangle() {
      PrintStream stdout = System.out;
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      System.setOut(new PrintStream(out));
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
       System.setOut(stdout);
   }
}