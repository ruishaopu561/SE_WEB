package rsp.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import rsp.demo1.module.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Iterable<Cart> findAllByUseremail(String useremail);
    Cart findByUseremailAndBookname(String useremail, String bookname);
    void deleteByUseremailAndBookname(String useremail, String bookname);
    void saveAndFlush(Cart cart);
}
