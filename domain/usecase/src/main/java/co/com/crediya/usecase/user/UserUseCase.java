package co.com.crediya.usecase.user;

import co.com.crediya.model.user.User;
import co.com.crediya.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    public Mono<User> getUser (String id) {
        return userRepository.getUser(id);
    }

    public Mono<User> saveUser (User user){
        return userRepository.saveUser(user);
    }



}
