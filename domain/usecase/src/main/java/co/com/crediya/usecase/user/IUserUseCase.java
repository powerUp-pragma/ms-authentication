package co.com.crediya.usecase.user;

import co.com.crediya.model.user.User;
import reactor.core.publisher.Mono;

public interface IUserUseCase {

    Mono<User> getUserById(String id);

    Mono<User> saveUser(User user);
}
