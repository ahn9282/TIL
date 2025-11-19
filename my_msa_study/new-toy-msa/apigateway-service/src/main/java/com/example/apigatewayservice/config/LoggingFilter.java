package com.example.apigatewayservice.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {
    public LoggingFilter(){
        super(Config.class);
    }

//    @Override
//    public GatewayFilter apply(LoggingFilter.Config config) {
//        return (exchange, chain) -> {
//
//            // Custom pre filter
//            ServerHttpRequest request = exchange.getRequest();
//            ServerHttpResponse response = exchange.getResponse();
//
//            log.info("Logging Filter baseMessage : {}, {}", config.getBaseMessage(), request.getRemoteAddress());
//            if(config.isPreLogger()) {
//                log.info("Logging PRE Filter start : request uri -> {}", request.getURI());
//            }
//
//            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                // custom post filter
//                if (config.isPostLogger()) {
//                    log.info("Logging POST Filter End : response code -> {}", response.getStatusCode());
//                }
//            }));
//        };
//    }

    /*
    * 우선 순위를 갖는 Logging Filter 적용
    * */
    @Override
    public GatewayFilter apply(LoggingFilter.Config config) {
        // 즉시 Return이 아닌 우선 순위를 가질 수 있는 OrderedGatewayFilter 로 감싸 우선 순위 지정 후 해당 filter 반환
        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) -> {

            // Custom pre filter
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Logging Filter baseMessage : {}, {}", config.getBaseMessage(), request.getRemoteAddress());
            if(config.isPreLogger()) {
                log.info("Logging PRE Filter start : request uri -> {}", request.getURI());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // custom post filter
                if (config.isPostLogger()) {
                    log.info("Logging POST Filter End : response code -> {}", response.getStatusCode());
                }
            }));
        }, Ordered.HIGHEST_PRECEDENCE);
        return filter;
    }

    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
