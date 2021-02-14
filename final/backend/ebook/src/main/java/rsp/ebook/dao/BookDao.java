package rsp.ebook.dao;

import rsp.ebook.entity.Book;
import rsp.ebook.entity.BookImage;
import rsp.ebook.entity.FullBook;
import rsp.ebook.entity.Item;

import java.util.List;

public interface BookDao{

    Book queryBook(Long id);

    FullBook queryFullBook(Long id);

    void removeByNameAndWriter(String name, String writer);

    void update(Book book);

    void storeNewBook(Book book, BookImage bookImage);

    List<FullBook> findAllBooks();

    void modifyBook(List<Item> items);

    void removeBook(List<Long> ids);

    void modifyOneBook(Long id, String name, String writer, int price, String isbn, int inventory);
}
