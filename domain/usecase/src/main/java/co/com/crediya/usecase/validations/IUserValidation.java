package co.com.crediya.usecase.validations;
import co.com.crediya.model.user.User;
import reactor.core.publisher.Mono;

public interface IUserValidation {


    Mono<User> registryUserValidator(User user);

    Mono<String> emailValidator(String email);

    Mono<String> nationalIdValidator(String nationalId);


}
