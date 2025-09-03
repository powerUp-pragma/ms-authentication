package co.com.crediya.model.user.gateways;

import co.com.crediya.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<User> getUserById(String id);
    Mono<User> saveUser(User user);
    Mono<User> getUserByEmail(String email);
    Mono<User> getUserByNationalId(String nationalId);
    Mono<User> updateUser(User user);
}
