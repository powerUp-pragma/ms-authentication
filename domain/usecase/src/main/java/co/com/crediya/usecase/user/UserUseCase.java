package co.com.crediya.usecase.user;

import co.com.crediya.model.user.User;
import co.com.crediya.model.user.gateways.UserRepository;
import co.com.crediya.usecase.validations.UserValidator;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase implements IUserUseCase {

    private final UserRepository userRepository;
    private final UserValidator userValidator;

    @Override
    public Mono<User> getUserById(String id) {
        if (id == null || id.isBlank()) {
            return Mono.error(new IllegalArgumentException("Id must not be null or empty"));
        }
        return userRepository.getUserById(id).switchIfEmpty(Mono.error(new RuntimeException("User not found with id:" + id)));

    }

    @Override
    public Mono<User> saveUser(User user) {
        return Mono.just(user)
                .flatMap(userValidator::registryUserValidator)
                .flatMap(userRepository::saveUser);
    }
}
