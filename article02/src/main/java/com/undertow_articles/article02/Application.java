package com.undertow_articles.article02;

import com.undertow_articles.article02.dagger.ApplicationComponent;
import com.undertow_articles.article02.dagger.DaggerApplicationComponent;
import io.undertow.Undertow;
import io.undertow.server.RoutingHandler;

public class Application {

	public static void main(String[] args){
		//Initialize Dagger Dependency Injection System
		//Note DaggerApplicationComponent is generated after compilation
		ApplicationComponent applicationComponent = DaggerApplicationComponent.create();

		//Initialize Routes
		final RoutingHandler routingHandler = new RoutingHandler();
		routingHandler.get("/health", applicationComponent.healthHandler());

		//Initialize Undertow Container System
		Undertow.Builder builder = Undertow.builder();
		builder.setIoThreads(2);
		builder.setWorkerThreads(10);
		builder.addHttpListener(8080, "0.0.0.0");
		builder.setHandler(routingHandler);
		Undertow server = builder.build();
		server.start();
	}
}