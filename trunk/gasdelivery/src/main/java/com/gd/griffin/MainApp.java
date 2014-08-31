package com.gd.griffin;

import static spark.Spark.get;
import static spark.SparkBase.setPort;

import java.io.IOException;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;

import com.gd.griffin.ui.FreeMarkerBasedRoute;
import com.gd.griffin.ui.FreeMarkerHelper;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MainApp {
	private final Configuration cfg;

	public static void main(String[] args) {
		System.out.println("Hello World!");
		new MainApp("mongodb://localhost");
	}

	public MainApp(String mongoURIString) {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient(new MongoClientURI(mongoURIString));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final DB blogDatabase = mongoClient.getDB("blog");

		// blogPostDAO = new BlogPostDAO(blogDatabase);
		// userDAO = new UserDAO(blogDatabase);
		// sessionDAO = new SessionDAO(blogDatabase);

		// cfg = createFreemarkerConfiguration();

		cfg = new FreeMarkerHelper().getFreeMarkerConfig();
		setPort(8082);

		// now initialize the routes so we can receive requests
		initializeRoutes(cfg);
	}

	private void initializeRoutes(Configuration cfg) {

		get("/", new FreeMarkerBasedRoute() {

			@Override
			public Object handle(Request arg0, Response arg1) {
				StringWriter html = new StringWriter();
				Template helloWorld = null;

				try {
					DBObject locals = new MongoClient().getDB("course")
							.getCollection("hello").findOne();

					Map<String, Object> attributes = new HashMap<>();
					attributes.put("message", "Hello Dave!");

					helloWorld = cfg.getTemplate("welcome.ftl");

					// helloWorld.process(locals, html);
					helloWorld.process(attributes, html);

				} catch (UnknownHostException e) {
					System.out.println("Cannot connect to MongoDB!");

				} catch (IOException e) {
					System.out.println("Cannot find the Hello World template!");
				} catch (TemplateException e) {
					System.out.println("Error while processing the template!");
				}

				return html;
			}
		});
	}
}
