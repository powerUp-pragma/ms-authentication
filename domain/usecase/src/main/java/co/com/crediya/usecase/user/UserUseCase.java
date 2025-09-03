package co.com.crediya.usecase.user;

import co.com.crediya.model.user.User;
import co.com.crediya.model.user.gateways.UserRepository;
import co.com.crediya.usecase.validations.EmailValidator;
import co.com.crediya.usecase.validations.NationalIdValidator;
import co.com.crediya.usecase.validations.UserValidator;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class UserUseCase implements IUserUseCase {

    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private final EmailValidator emailValidator;
    private final NationalIdValidator nationalIdValidator;

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

    @Override
    public Mono<User> getUserByEmail(String email) {
        return emailValidator.emailValidate(email)
                .flatMap(user -> userRepository.getUserByEmail(email));
    }

    @Override
    public Mono<User> getUserByNationalId(String nationalId) {
        return nationalIdValidator.nationalIdValidate(nationalId)
                .flatMap(user -> userRepository.getUserByNationalId(nationalId));
    }

    @Override
    public Mono<User> updateUser(User user) {
        return null;
    }
}
