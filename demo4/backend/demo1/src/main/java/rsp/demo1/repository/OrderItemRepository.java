package rsp.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import rsp.demo1.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    void deleteById(Long id);

    void saveAndFlush(OrderItem orderItem);
}
