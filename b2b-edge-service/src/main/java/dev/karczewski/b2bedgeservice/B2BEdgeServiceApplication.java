package dev.karczewski.b2bedgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class B2BEdgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(B2BEdgeServiceApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v1/token/**")
                        .filters(GatewayFilterSpec::tokenRelay)
                        .uri("http://localhost:9001"))
                .build();
    }

}
