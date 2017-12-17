package ru.job4j.pseudo;

public class Triangle implements Shape {

   @Override
   public String draw() {
      String ln = System.lineSeparator();
      StringBuilder pic = new StringBuilder();
      pic.append("   +   ");
      pic.append(ln);
      pic.append("  ***  ");
      pic.append(ln);
      pic.append(" ***** ");
      pic.append(ln);
      pic.append("*******");
      pic.append(ln);
      return pic.toString();
   }
}