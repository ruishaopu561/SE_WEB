package rsp.ebook.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import rsp.ebook.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findBookById(Long Id);

    Book findBookByNameAndWriter(String name, String writer);

    void deleteByNameAndWriter(String name, String writer);

    void saveAndFlush(Book book);

    @Modifying
    @Transactional
    void deleteBookById(Long id);
}
