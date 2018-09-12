package ru.p4b.dev.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void distance() {
    Point p1 = new Point(6, 7);
    Point p2 = new Point(9,10);
    Assert.assertEquals(p1.distance(p2), 4.242640687119285);
  }
}
