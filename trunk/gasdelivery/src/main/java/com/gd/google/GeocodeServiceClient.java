package com.gd.google;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;

public class GeocodeServiceClient {

	private static final String GOOGLE_API_URL = "https://maps.googleapis.com/maps/api/geocode/json?";

	private static final String DEFAULT_KEY = "AIzaSyB4s2cl6S7TrZeWl1yDcZtMdtfTqvQ7tW8";

	private GeocodeServiceClient() {

	}

	public static String geocode(String address) throws Exception {
		URL url = new URL(GOOGLE_API_URL + "address="
				+ URLEncoder.encode(address, "UTF-8") + "&key=" + DEFAULT_KEY);
		URLConnection conn = url.openConnection();
		ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
		IOUtils.copy(conn.getInputStream(), output);
		output.close();
		return output.toString();
	}

}
