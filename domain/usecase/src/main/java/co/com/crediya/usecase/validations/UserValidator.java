package co.com.crediya.usecase.validations;

import co.com.crediya.model.user.User;

import reactor.core.publisher.Mono;

import java.math.BigInteger;


public class UserValidator {


    public Mono<User> registryUserValidator(User user) {
        if (user == null) {
            return Mono.error(new IllegalArgumentException("User must not be null"));
        }
        if (user.getFirstName() == null || user.getFirstName().isBlank()) {
            return Mono.error(new IllegalArgumentException("Name field is mandatory"));
        }
        if (user.getEmail() == null || !user.getEmail().matches("[^@ ]+@[^@ ]+\\.[^@ ]+")) {
            return Mono.error(new IllegalArgumentException("Email is invalid"));
        }
        if (user.getSalary() == null || user.getSalary().compareTo(BigInteger.ZERO) < 0) {
            return Mono.error(new IllegalArgumentException("Salary must be a non-negative number"));
        }
        return Mono.just(user);
    }
}
