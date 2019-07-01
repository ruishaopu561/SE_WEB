package rsp.demo1.service;

import rsp.demo1.entity.Book;
import rsp.demo1.entity.FullBook;

import java.util.List;
import java.util.Map;

public interface BookService {

//    Book getBook(Long id);
    FullBook getBook(Long id);

    void removeBook(String name, String writer);

    List<FullBook> getAllBooks();

    void update(Book book);

    void addBook(Map<String, String> maps);

    void removeBooks(List<Long> ids);

    void modifyBooks(List<Map<String, String>> maps);
}
