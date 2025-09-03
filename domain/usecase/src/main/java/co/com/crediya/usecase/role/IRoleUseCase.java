package co.com.crediya.usecase.role;

import co.com.crediya.model.role.Role;
import reactor.core.publisher.Mono;

public interface IRoleUseCase {

    Mono<Role> getRoleById(String id);

    Mono<Role> saveRole(Role role);
}
