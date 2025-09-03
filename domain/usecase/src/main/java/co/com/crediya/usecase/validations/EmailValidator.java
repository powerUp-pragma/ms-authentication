package co.com.crediya.usecase.validations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class EmailValidator {
    public Mono<String> emailValidate(String email){
        if (email == null || email.matches("[^@ ]+@[^@ ]+\\.[^@ ]+")) {
            return Mono.error(new IllegalArgumentException("Email is invalid"));
        }
        return Mono.just(email);
    }
}
