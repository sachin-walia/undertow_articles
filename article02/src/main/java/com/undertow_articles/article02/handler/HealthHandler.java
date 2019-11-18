package com.undertow_articles.article02.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import org.apache.commons.collections4.map.SingletonMap;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Sachin Walia on 11/17/19.
 */
@Singleton
public class HealthHandler implements HttpHandler {

    private final ObjectMapper objectMapper;

    @Inject
    public HealthHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().add(new HttpString("Content-type"), "application/json");
        exchange.getResponseSender().send(objectMapper.writeValueAsString(new SingletonMap<>("status", "UP")));
    }

}
