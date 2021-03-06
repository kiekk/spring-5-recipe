package com.example.recipe591;

import com.example.recipe591.reactive.court.WebFluxConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

@SpringBootApplication
public class Recipe591Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebFluxConfiguration.class);
        HttpHandler handler =
                WebHttpHandlerBuilder.applicationContext(context).build();

        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);

        HttpServer.create().host("localhost").port(8080).handle(adapter).bind().block();
    }

}
