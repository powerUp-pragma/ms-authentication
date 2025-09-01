package co.com.crediya.model.user.gateways;

import co.com.crediya.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<User> getUser(String id);

    Mono<User> saveUser(User user);

    Mono<User> updateUser(User user);
}
