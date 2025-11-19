package com.example.apigatewayservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
    public CustomFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(CustomFilter.Config config) {
        return (exchange, chain) -> {

            // Custom pre filter
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Custom PRE Filter : request id -> {}", request.getId());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // custom post filter
                log.info("Custom POST Filter : response code -> {}", response.getStatusCode());
            }));
        };
    }

    public static class Config {

    }
}
