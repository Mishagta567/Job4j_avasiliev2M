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
   public void whenDrawSquare() {
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

      String ln = System.lineSeparator();
      StringBuilder pic = new StringBuilder();
      //pic.append("Квадрат:");
      //pic.append(ln);
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
}