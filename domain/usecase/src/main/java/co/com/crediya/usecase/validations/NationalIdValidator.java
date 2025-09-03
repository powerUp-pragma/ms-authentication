package co.com.crediya.usecase.validations;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class NationalIdValidator {

    public Mono<String> nationalIdValidate(String nationalId){
        if (nationalId == null || !nationalId.matches("^\\d{6,10}$")) {
            return Mono.error(new IllegalArgumentException("nationalId is not valid for Colombia citizens"));
        }
        return Mono.just(nationalId);

    }
}
