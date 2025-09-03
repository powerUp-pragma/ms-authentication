package co.com.crediya.usecase.role;

import co.com.crediya.model.role.Role;
import co.com.crediya.model.role.gateways.RoleRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RoleUseCase implements IRoleUseCase{

    private RoleRepository roleRepository;


    @Override
    public Mono<Role> getRoleById(String id) {
        return roleRepository.getRoleById(id);
    }

    @Override
    public Mono<Role> saveRole(Role role) {
        return roleRepository.saveRole(role);
    }
}
