package co.com.crediya.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class RouterRest {

    private final Handler userHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        log.info("router function init");
        return route(GET("/api/v1/user/{id}"), userHandler::listenGetUserById)
                .andRoute(GET("/api/v1/user/{email}"), userHandler::listenGetUserByEmail)
                .andRoute(POST("/api/v1/save"), userHandler::listenPostSaveUser);
    }
}
