package rsp.demo1.daoImpl;

import rsp.demo1.entity.Book;
import rsp.demo1.dao.BookDao;
import rsp.demo1.entity.OrderItem;
import rsp.demo1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bp;

    @Override
    public void update(Book book){bp.saveAndFlush(book);}

    @Override
    public Book queryObject(Long id){
        return bp.findBookById(id);
    }

    @Override
    public void removeByNameAndWriter(String name, String writer){
        bp.deleteByNameAndWriter(name, writer);
    }

    @Override
    public Iterable<Book> findAllBooks(){
        return bp.findAll();
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
}
