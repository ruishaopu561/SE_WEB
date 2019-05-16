package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.repository.BookReporitory;
import rsp.demo1.module.Book;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookReporitory bp;

    @ResponseBody
    @GetMapping(value = "/book")
    public Iterable<Book> getBooks(){
        return bp.findAll();
    }

    @ResponseBody
    @PostMapping(value = "/item")
    public Optional<Book> getItem(@RequestBody Long id){
        System.out.println(bp.findById(id));
        return bp.findById(id);
    }

    @Modifying
    @ResponseBody
    @PostMapping(value = "/modifyBooks")
    public void modifyBook(Iterable<Book> modifyBooks){
        try{
            for(Book b:modifyBooks){
                Book dbBook = bp.findByNameAndWriter(b.getName(), b.getWriter());
                dbBook.setInventory(b.getInventory());
                dbBook.setPrice(b.getPrice());
                bp.saveAndFlush(dbBook);
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
                bp.deleteByNameAndWriter(b.getName(), b.getWriter());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @Modifying
//    @ResponseBody
//    @PostMapping(value = "/modifyBook")
//    public void modifyBook(Book b){
//        try{
//            Book dbBook = bp.findByNameAndWriter(b.getName(), b.getWriter());
//            dbBook.setInventory(b.getInventory());
//            dbBook.setPrice(b.getPrice());
//            bp.saveAndFlush(dbBook);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Modifying
//    @Transactional
//    @DeleteMapping(value = "/deleteBook")
//    public void deleteABook(String name, String writer){
//        bp.deleteByNameAndWriter(name, writer);
//    }
}
