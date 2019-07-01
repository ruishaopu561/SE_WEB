package rsp.demo1.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import rsp.demo1.dao.BookDao;
import rsp.demo1.entity.*;
import rsp.demo1.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bp;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void update(Book book){ bp.saveAndFlush(book); }

    @Override
    public void storeNewBook(Book book, BookImage bookImage){
        bp.saveAndFlush(book);
        Book book1 = bp.findBookByNameAndWriter(book.getName(), book.getWriter());
        bookImage.setBookId(String.valueOf(book1.id));
        mongoTemplate.insert(bookImage);
    }

    @Override
    public Book queryBook(Long id){
        return bp.findBookById(id);
    }

    @Override
    public FullBook queryFullBook(Long id){
        Book book = bp.findBookById(id);
        Query query = Query.query(Criteria.where("bookId").is(String.valueOf(id)));
        BookImage bookImage = mongoTemplate.findOne(query, BookImage.class);
        try{
            if(book!=null && bookImage!=null){
                return new FullBook(book.id, book.getName(),book.getWriter(),book.getISBN(),book.getPrice(),book.getInventory(), bookImage.getImage());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeByNameAndWriter(String name, String writer){
        bp.deleteByNameAndWriter(name, writer);
    }

    @Override
    public List<FullBook> findAllBooks(){
        Iterable<Book> books = bp.findAll();
        List<FullBook> fullBooks = new ArrayList<FullBook>();
        for(Book b:books){
            Query query = Query.query(Criteria.where("bookId").is(String.valueOf(b.id)));
            BookImage bi = mongoTemplate.findOne(query, BookImage.class);
            if(bi != null) {
                FullBook fb = new FullBook(b.id, b.getName(), b.getWriter(), b.getISBN(), b.getPrice(), b.getInventory(), bi.getImage());
                fullBooks.add(fb);
            }
        }
        return fullBooks;
    }

    @Override
    public void modifyBook(List<OrderItem> orderItems){
        try{
            System.out.println(orderItems);
            for(OrderItem oi:orderItems){
                Book b = bp.findBookById(oi.getBook().id);
                System.out.println(b);
                b.setInventory(b.getInventory()-oi.getAmount());
                System.out.println(b.getInventory());
                bp.saveAndFlush(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void modifyOneBook(Long id, String name, String writer, int price, String isbn, int inventory){
        try{
            Book b = bp.findBookById(id);
            b.setName(name);
            b.setWriter(writer);
            b.setPrice(price);
            b.setISBN(isbn);
            b.setInventory(inventory);

            bp.saveAndFlush(b);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeBook(List<Long> ids){
        try{
            for(Long id:ids){
                bp.deleteBookById(id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
