package ru.p4b.dev.soap;


import com.buzzbuzhome.BBHLocation;
import com.buzzbuzhome.GeoIP;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    BBHLocation geoIP = new GeoIP().getGeoIPSoap12().getUserLocation("85.118.228.242");
    assertEquals(geoIP.getCountryCode(), "US");
  }

  @Test
  public void testInvalidIp() {
    BBHLocation geoIP = new GeoIP().getGeoIPSoap12().getUserLocation("85.118.228.xxx");
    assertEquals(geoIP.getCountryCode(), "RUS");
  }
}
