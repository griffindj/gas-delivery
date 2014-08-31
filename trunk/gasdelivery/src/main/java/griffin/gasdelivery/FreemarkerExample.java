package griffin.gasdelivery;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class FreemarkerExample {

	public static void main(String args[]) {

		get("/hello", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("message", "Hello World!");

			// The hello.ftl file is located in directory:
			// src/test/resources/spark/template/freemarker
				return new ModelAndView(attributes,
						"src/main/java/resources/hello.ftl");
			}, new FreeMarkerEngine());

	}

}