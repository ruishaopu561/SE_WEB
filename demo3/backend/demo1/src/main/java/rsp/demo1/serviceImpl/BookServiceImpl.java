package rsp.demo1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rsp.demo1.dao.BookDao;
import rsp.demo1.entity.Book;
import rsp.demo1.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bd;

    @Override
    public Book getBook(Long id){
        return bd.queryObject(id);
    }

    @Override
    public void removeBook(String name, String writer){
        bd.removeByNameAndWriter(name, writer);
    }

    @Override
    public void update(Book book){bd.update(book);}

    @Override
    public Iterable<Book> getAllBooks(){
        return bd.findAllBooks();
    }

}
