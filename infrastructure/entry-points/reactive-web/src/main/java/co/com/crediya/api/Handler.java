package co.com.crediya.api;

import co.com.crediya.api.dto.GetUserDto;
import co.com.crediya.api.dto.SaveUserDto;
import co.com.crediya.model.user.User;
import co.com.crediya.usecase.user.UserUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Instant;


@Component
@RequiredArgsConstructor
public class Handler {

    private final UserUseCase userUseCase;
    private final ObjectMapper objectMapper;

//private  final UseCase2 useCase2;

    public Mono<ServerResponse> listenGetUserById(ServerRequest serverRequest) {
        return extractUserId(serverRequest)
                .flatMap(userUseCase::getUser)
                .flatMap(this::mapToUserDto)
                .flatMap(this::buildSuccessResponse)
                .switchIfEmpty(ServerResponse.notFound().build())
                .onErrorResume(this::handleError);
    }

    public Mono<ServerResponse> listenPostSaveUser(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(SaveUserDto.class)
                .map(user -> objectMapper.convertValue(user, User.class))
                .flatMap(userUseCase::saveUser)
                .flatMap(user -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON).bodyValue(
                                user
                        ));
    }


    private Mono<String> extractUserId(ServerRequest serverRequest) {
        return Mono.fromCallable(() -> serverRequest.pathVariable("id"))
                .map(String::trim)
                .filter(id -> !id.isBlank())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("User ID cannot be empty")));
    }

    private Mono<GetUserDto> mapToUserDto(User user) {
        return Mono.fromCallable(() -> objectMapper.convertValue(user, GetUserDto.class))
                .onErrorMap(e -> new RuntimeException("Failed to convert user to DTO", e));
    }

    private Mono<ServerResponse> buildSuccessResponse(GetUserDto userDto) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userDto);
    }

    private Mono<ServerResponse> handleError(Throwable throwable) {
        if (throwable instanceof IllegalArgumentException) {
            return ServerResponse.badRequest()
                    .bodyValue(new ErrorResponse("Invalid input", throwable.getMessage()));
        }

        if (throwable instanceof RuntimeException) {
            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .bodyValue(new ErrorResponse("Processing error", "Failed to process user data"));
        }

        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .bodyValue(new ErrorResponse("Server error", "Please try again later"));
    }

    public record ErrorResponse(
            String error,
            String message,
            Instant timestamp
    ) {
        public ErrorResponse(String error, String message) {
            this(error, message, Instant.now());
        }
    }


}

