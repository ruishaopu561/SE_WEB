package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.repository.BookReporitory;
import rsp.demo1.module.Book;

import javax.transaction.Transactional;

@Controller
public class BookController {
    @Autowired
    private BookReporitory bp;

    @ResponseBody
    @GetMapping(value = "/book")
    public Iterable<Book> getBooks(){
        return bp.findAll();
    }

    @Modifying
    @ResponseBody
    @PostMapping(value = "/modifyBook")
    public void modifyBook(Book b){
        try{
            Book dbBook = bp.findByNameAndWriter(b.getName(), b.getWriter());
            dbBook.setInventory(b.getInventory());
            dbBook.setPrice(b.getPrice());
            bp.saveAndFlush(dbBook);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Modifying
    @Transactional
    @DeleteMapping(value = "/deleteBook")
    public void deleteABook(String name, String writer){
        bp.deleteByNameAndWriter(name, writer);
    }
}
