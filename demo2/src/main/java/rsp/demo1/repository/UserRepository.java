package rsp.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import rsp.demo1.module.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    void saveAndFlush(User user);
    Iterable<User> findAllByActive(boolean active);
}
