package com.gd.google;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;

public class GCoder {
	// private static final String URL =
	// "http://maps.google.com/maps/geo?output=json";
	private static final String URL = "https://maps.googleapis.com/maps/api/geocode/json?";

	private static final String DEFAULT_KEY = "AIzaSyB4s2cl6S7TrZeWl1yDcZtMdtfTqvQ7tW8";

	public static String geocode(String address) throws Exception {
		URL url = new URL(URL + "address="
				+ URLEncoder.encode(address, "UTF-8") + "&key=" + DEFAULT_KEY);
		URLConnection conn = url.openConnection();
		ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
		IOUtils.copy(conn.getInputStream(), output);
		output.close();

		// GAddress gaddr = new GAddress();
		// JSONObject json = JSONObject.fromObject(output.toString());
		// JSONObject placemark = (JSONObject) query(json, "Placemark[0]");
		// final String commonId = "AddressDetails.Country.AdministrativeArea";
		// gaddr.setFullAddress(query(placemark, "address").toString());
		// gaddr.setZipCode(query(
		// placemark,
		// commonId
		// + ".SubAdministrativeArea.Locality.PostalCode.PostalCodeNumber")
		// .toString());
		// gaddr.setAddress(query(
		// placemark,
		// commonId
		// + ".SubAdministrativeArea.Locality.Thoroughfare.ThoroughfareName")
		// .toString());
		// gaddr.setCity(query(placemark,
		// commonId + ".SubAdministrativeArea.SubAdministrativeAreaName")
		// .toString());
		// gaddr.setState(query(placemark, commonId + ".AdministrativeAreaName")
		// .toString());
		// gaddr.setLat(Double
		// .parseDouble(query(placemark, "Point.coordinates[1]")
		// .toString()));
		// gaddr.setLng(Double
		// .parseDouble(query(placemark, "Point.coordinates[0]")
		// .toString()));
		return output.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(GCoder
				.geocode("4513+Hendricks+Drive,+Woodbridge,+VA"));
		System.out.println(GCoder.geocode("94103"));
		System.out
				.println(GCoder
						.geocode("peña 2700 capital federal cdad. autonoma de buenos aires"));
		System.out
				.println(GCoder
						.geocode("2700 peña, capital federal, ciudad autonoma de buenos aires, argentina"));

	}
}
