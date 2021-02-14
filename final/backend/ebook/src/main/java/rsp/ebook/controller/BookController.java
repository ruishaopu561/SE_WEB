package rsp.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import rsp.ebook.entity.FullBook;
import rsp.ebook.service.BookService;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookService bs;

    @ResponseBody
    @GetMapping(value = "/books")
    public List<FullBook> getBooks(){
        return bs.getAllBooks();
    }

    @ResponseBody
    @PostMapping(value = "/item")
    public FullBook getItem(@RequestBody Long id){ return bs.getBook(id); }

    // insert
    @ResponseBody
    @PostMapping(value = "/books")
    public void addBook(@RequestBody Map<String, String> maps) {
        System.out.println(maps);
        bs.addBook(maps);
    }

//    @Modifying
    @ResponseBody
    @PutMapping(value = "/books")
    public void modifyBook(@RequestBody List<Map<String, String>> maps) {
        bs.modifyBooks(maps);
    }

    @ResponseBody
    @DeleteMapping(value = "/books")
    public void deleteBooks(@RequestBody List<Long> ids) {
        bs.removeBooks(ids);
    }
}
