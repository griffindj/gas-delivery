package griffin.gasdelivery;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class HelloWorld {

	public static void main(String[] args) {
		get("/hello", (request, response) -> {
			Map attributes = new HashMap();
			attributes.put("message", "Hello World!");

			// The hello.ftl file is located in directory:
			// src/test/resources/spark/template/freemarker
				return new ModelAndView(attributes,
						"src/main/java/resources/hello.ftl");
			}, new FreeMarkerEngine());

		post("/", (request, response) -> {
			// .. Create something ..
				return "post";
			});

		put("/", (request, response) -> {
			// .. Update something ..
				return "put";
			});

		delete("/", (request, response) -> {
			// .. annihilate something ..
				return "delete";
			});

		options("/", (request, response) -> {
			// .. appease something ..
				return "options";
			});

		// matches "GET /hello/foo" and "GET /hello/bar"
		// request.params(":name") is 'foo' or 'bar'
		get("/hello/:name", (request, response) -> {
			return "Hello: " + request.params(":name");
		});

		// matches "GET /say/hello/to/world"
		// request.splat()[0] is 'hello' and request.splat()[1] 'world'
		get("/say/*/to/*", (request, response) -> {
			return "Nbr of splat parameters: " + request.splat().length;
		});
	}

}