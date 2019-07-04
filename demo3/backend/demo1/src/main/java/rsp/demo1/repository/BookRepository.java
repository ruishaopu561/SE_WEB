package rsp.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import rsp.demo1.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findBookById(Long Id);

    void deleteByNameAndWriter(String name, String writer);

//    void saveAndFlush();

    void saveAndFlush(Book book);
}
