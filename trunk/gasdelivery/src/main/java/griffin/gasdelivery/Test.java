package griffin.gasdelivery;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class Test {

	public static void main(String[] args) throws Exception {

		/*
		 * ----------------------------------------------------------------------
		 * -
		 */
		/* You should do this ONLY ONCE in the whole application life-cycle: */

		/* Create and adjust the configuration */
		Configuration cfg = new Configuration();

		cfg.setDirectoryForTemplateLoading(new File("src/main/java/resources/"));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));

		/*
		 * ----------------------------------------------------------------------
		 * -
		 */
		/* You usually do these for many times in the application life-cycle: */

		/* Create a data-model */
		Map root = new HashMap();
		root.put("username", "Big Joe");

		// Map latest = new HashMap();
		// root.put("latestProduct", latest);
		// latest.put("url", "products/greenmouse.html");
		// latest.put("name", "green mouse");

		/* Get the template */
		Template temp = cfg.getTemplate("welcome.ftl");

		/* Merge data-model with template */
		Writer out = new OutputStreamWriter(System.out);

		temp.process(root, out);

	}
}