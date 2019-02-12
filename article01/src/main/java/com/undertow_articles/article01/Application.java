package com.undertow_articles.article01;

import io.undertow.Undertow;
import static io.undertow.Handlers.path;

public class Application {

	public static void main(String[] args){
		Undertow.Builder builder = Undertow.builder();
		builder.setIoThreads(2);
		builder.setWorkerThreads(10);
		builder.addHttpListener(8080, "0.0.0.0");
		builder.setHandler(path()
			.addPrefixPath("/", exchange -> {
				exchange.getResponseSender().send("Hello World");
			})
		);
		Undertow server = builder.build();
		server.start();
	}
}