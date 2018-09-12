package ru.p4b.dev.sandbox;

public class MySecondPr {


    public static void main(String[] args) {
      Point p1 = new Point(56, 78);
      Point p2 = new Point(3, 9);

      System.out.println("Расстояние между двумя точками = " + distance(p1, p2));
    }
    public static double distance(Point p1, Point p2) {
      return Math.sqrt(Math.pow((p2.a-p1.a),2) + Math.pow((p2.b-p1.b),2));
    }
}
