package rsp.demo1.repository;

import org.springframework.data.repository.CrudRepository;
import rsp.demo1.module.Book;

public interface BookReporitory extends CrudRepository<Book, Long> {
    void deleteByNameAndWriter(String name, String writer);
    Book findByNameAndWriter(String name, String writer);
    void saveAndFlush(Book book);
}
