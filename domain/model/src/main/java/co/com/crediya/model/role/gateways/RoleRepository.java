package co.com.crediya.model.role.gateways;

import co.com.crediya.model.role.Role;
import reactor.core.publisher.Mono;

public interface RoleRepository {

    Mono<Role> getRoleById(String id);

    Mono<Role> saveRole(Role role);
}

