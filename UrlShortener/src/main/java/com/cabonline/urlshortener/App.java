package com.cabonline.urlshortener;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("server.port", 8081);
		new SpringApplicationBuilder(App.class).properties(props)
				.registerShutdownHook(true).run(args);

	}
}
