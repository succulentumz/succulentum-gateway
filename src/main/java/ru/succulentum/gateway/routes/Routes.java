package ru.succulentum.gateway.routes;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import ru.succulentum.gateway.config.ServicesUrlConfig;

@Configuration
@AllArgsConstructor
public class Routes {
    private final ServicesUrlConfig servicesUrlConfig;

    @Bean
    public RouterFunction<ServerResponse> collectionServiceRoute() {
        return GatewayRouterFunctions.route("collection_service")
                .route(
                        RequestPredicates.path("/api/collection/**"),
                        HandlerFunctions.http(servicesUrlConfig.getCollectionServiceUrl()))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> usersServiceRoute() {
        return GatewayRouterFunctions.route("users_service")
                .route(
                        RequestPredicates.path("/api/users/**"),
                        HandlerFunctions.http(servicesUrlConfig.getUsersServiceUrl()))
                .build();
    }
}
