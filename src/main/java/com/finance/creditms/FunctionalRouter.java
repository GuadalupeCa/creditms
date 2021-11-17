package com.finance.creditms;

import com.finance.creditms.handler.CreditHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class FunctionalRouter {
    @Bean
    public RouterFunction<ServerResponse> route(CreditHandler creditHandler) {
        return RouterFunctions
                .route(GET("/credit").and(accept(MediaType.APPLICATION_JSON)), creditHandler::findAll)
                .andRoute(GET("/credit/{id}").and(accept(MediaType.APPLICATION_JSON)), creditHandler::findById)
                .andRoute(GET("/credit/account/{account}").and(accept(MediaType.APPLICATION_JSON)), creditHandler::findByAccount)
                .andRoute(POST("/credit/save").and(accept(MediaType.APPLICATION_JSON)), creditHandler::save)
                .andRoute(PUT("/credit/update").and(accept(MediaType.APPLICATION_JSON)), creditHandler::update)
                .andRoute(DELETE("/credit/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), creditHandler::deleteById);
    }
}
