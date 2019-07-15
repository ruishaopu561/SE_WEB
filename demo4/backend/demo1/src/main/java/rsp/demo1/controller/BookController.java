package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.entity.FullBook;
import rsp.demo1.service.BookService;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookService bs;

    @ResponseBody
    @GetMapping(value = "/book")
    public List<FullBook> getBooks(){
        return bs.getAllBooks();
    }

    @ResponseBody
    @PostMapping(value = "/item")
    public FullBook getItem(@RequestBody Long id){ return bs.getBook(id); }

    @ResponseBody
    @PostMapping(value = "/addbook")
    public void addBook(@RequestBody Map<String, String> maps){ bs.addBook(maps); }

    @Modifying
    @ResponseBody
    @PostMapping(value = "/modifybooks")
    public void modifyBook(@RequestBody List<Map<String, String>> maps){ bs.modifyBooks(maps); }

    @ResponseBody
    @PostMapping(value = "/deletebooks")
    public void deleteBooks(@RequestBody List<Long> ids) { bs.removeBooks(ids); }
}
