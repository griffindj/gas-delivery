package griffin.gasdelivery;

import static spark.Spark.get;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldMongoFreeMarker {

	public static void main(String[] args) throws IOException {

		final Configuration template = new Configuration();
		template.setDirectoryForTemplateLoading(new File(
				"src/main/java/resources/"));

		get("/", new Route() {

			@Override
			public Object handle(Request arg0, Response arg1) {
				StringWriter html = new StringWriter();
				Template helloWorld = null;

				try {
					DBObject locals = new MongoClient().getDB("course")
							.getCollection("hello").findOne();

					Map<String, Object> attributes = new HashMap<>();
					attributes.put("message", "Hello World!");

					helloWorld = template.getTemplate("hello.ftl");

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