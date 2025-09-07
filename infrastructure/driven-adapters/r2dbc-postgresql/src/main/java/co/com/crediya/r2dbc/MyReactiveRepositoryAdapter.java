package co.com.crediya.r2dbc;

import co.com.crediya.model.user.User;
import co.com.crediya.model.user.gateways.UserRepository;
import co.com.crediya.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class MyReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        User,
    UserEntity,
    UUID,
    MyReactiveRepository
> implements UserRepository {
    private final TransactionalOperator transactionalOperator;


    public MyReactiveRepositoryAdapter(MyReactiveRepository repository, ObjectMapper mapper, TransactionalOperator transactionalOperator) {
        super(repository, mapper, d -> mapper.map(d, User.class));
        this.transactionalOperator = transactionalOperator;
    }

    @Override
    public Mono<User> getUserById(@Param("id")String id) {
        return super.findById(UUID.fromString(id));
    }


    @Override
    public Mono<User> saveUser(User user) {
        return transactionalOperator.transactional(super.save(user));
    }

    @Override
    public Mono<User> getUserByEmail(String email) {
        return null;
    }

    @Override
    public Mono<User> getUserByNationalId(String nationalId) {
        return null;
    }

    @Override
    public Mono<User> updateUser(User user) {
        return null;
    }
}
