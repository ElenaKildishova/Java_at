package ru.p4b.dev.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void testDistance1() {
    Point p1 = new Point(6, 7);
    Point p2 = new Point(9,10);
    Assert.assertEquals(p1.distance(p2), 4.242640687119285);
  }
  @Test
  public void testDistance2() {
    Point p1 = new Point(-1, -1);
    Point p2 = new Point(-1,-1);
    Assert.assertEquals(p1.distance(p2), 0.0);
  }
  @Test
  public void testDistance3() {
    Point p1 = new Point(-11, 887);
    Point p2 = new Point(9,0);
    Assert.assertEquals(p1.distance(p2), 887.2254504915873);
  }
}
