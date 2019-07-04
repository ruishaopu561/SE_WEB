package rsp.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import rsp.demo1.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long> {

    void saveAndFlush(Orders order);

    Iterable<Orders> findAllByUser_IdAndPaied(Long userid, boolean paied);

    Orders findByIdAndUser_Id(Long id, Long userid);
}
