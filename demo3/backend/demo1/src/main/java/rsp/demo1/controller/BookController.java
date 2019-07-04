package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.entity.Book;
import rsp.demo1.service.BookService;

import javax.transaction.Transactional;

@RestController
public class BookController {

    @Autowired
    private BookService bs;

    @ResponseBody
    @GetMapping(value = "/book")
    public Iterable<Book> getBooks(){
        return bs.getAllBooks();
    }

    @ResponseBody
    @PostMapping(value = "/item")
    public Book getItem(@RequestBody Long id){ return bs.getBook(id); }

    @Modifying
    @ResponseBody
    @PostMapping(value = "/modifyBooks")
    public void modifyBook(Iterable<Book> modifyBooks){
        try{
            for(Book b:modifyBooks){
                Book dbBook = bs.getBook(b.id);
                dbBook.setInventory(b.getInventory());
                dbBook.setPrice(b.getPrice());
                bs.update(dbBook);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Modifying
    @Transactional
    @DeleteMapping(value = "/deleteBooks")
    public void deleteABook(Iterable<Book> deleteBooks)
    {
        try{
            for (Book b:deleteBooks){
                bs.removeBook(b.getName(), b.getWriter());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
