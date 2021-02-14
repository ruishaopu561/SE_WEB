package rsp.ebook.repository;

import org.springframework.data.repository.CrudRepository;
import rsp.ebook.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

    void saveAndFlush(Order order);

    Iterable<Order> findAllByUser_IdAndPaied(Long userid, boolean paied);

    Order findByIdAndUser_Id(Long id, Long userid);
}
