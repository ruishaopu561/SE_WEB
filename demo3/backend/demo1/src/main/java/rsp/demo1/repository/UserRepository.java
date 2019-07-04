package rsp.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import rsp.demo1.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserById(Long id);

    User findByEmail(String email);

    void saveAndFlush(User user);

    Iterable<User> findAllByActive(boolean active);

}
