package rsp.ebook.repository;

import org.springframework.data.repository.CrudRepository;
import rsp.ebook.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

    void deleteById(Long id);

    void saveAndFlush(Item orderItem);
}
