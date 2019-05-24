package rsp.demo1.dao;

import rsp.demo1.entity.Book;
import rsp.demo1.entity.OrderItem;

import java.util.List;

public interface BookDao{

    Book queryObject(Long id);

    void removeByNameAndWriter(String name, String writer);

    void update(Book book);

    Iterable<Book> findAllBooks();

    void modifyBook(List<OrderItem> orderItems);
}
