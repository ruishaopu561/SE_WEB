package rsp.demo1.dao;

import rsp.demo1.entity.Book;
import rsp.demo1.entity.BookImage;
import rsp.demo1.entity.FullBook;
import rsp.demo1.entity.OrderItem;

import java.util.List;

public interface BookDao{

    Book queryBook(Long id);

    FullBook queryFullBook(Long id);

    void removeByNameAndWriter(String name, String writer);

    void update(Book book);

    void storeNewBook(Book book, BookImage bookImage);

    List<FullBook> findAllBooks();

    void modifyBook(List<OrderItem> orderItems);

    void removeBook(List<Long> ids);

    void modifyOneBook(Long id, String name, String writer, int price, String isbn, int inventory);
}
