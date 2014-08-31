package com.gd.griffin.ui;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;

public class FreeMarkerHelper {

	Configuration freeMarkerConfig;

	public FreeMarkerHelper() {
		freeMarkerConfig = createFreemarkerConfiguration();
	}

	private Configuration createFreemarkerConfiguration() {
		this.freeMarkerConfig = new Configuration();
		try {
			this.freeMarkerConfig.setDirectoryForTemplateLoading(new File(
					"src/main/java/resources/"));
		} catch (IOException e) {
			System.out
					.println("couldn't load the FreeMarker template directory");
			e.printStackTrace();
		}
		return freeMarkerConfig;
	}

	public Configuration getFreeMarkerConfig() {
		return freeMarkerConfig;
	}
}
