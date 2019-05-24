package rsp.demo1.service;

import rsp.demo1.entity.Book;

public interface BookService {

    Book getBook(Long id);

    void removeBook(String name, String writer);

    Iterable<Book> getAllBooks();

    void update(Book book);
}
