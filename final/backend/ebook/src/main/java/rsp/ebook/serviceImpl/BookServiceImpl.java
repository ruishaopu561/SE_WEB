package rsp.ebook.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rsp.ebook.dao.BookDao;
import rsp.ebook.entity.Book;
import rsp.ebook.entity.BookImage;
import rsp.ebook.entity.FullBook;
import rsp.ebook.service.BookService;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bd;

    @Override
    public FullBook getBook(Long id){
        return bd.queryFullBook(id);
    }

    @Override
    public void removeBook(String name, String writer){
        bd.removeByNameAndWriter(name, writer);
    }

    @Override
    public List<FullBook> getAllBooks(){
        return bd.findAllBooks();
    }

    @Override
    public void update(Book book){bd.update(book);}

    @Override
    public void addBook(Map<String, String> maps) {
        String name = maps.get("name");
        String writer = maps.get("writer");
        int price = Integer.parseInt(maps.get("price"));
        String isbn = maps.get("isbn");
        int inventory = Integer.parseInt(maps.get("inventory"));
        String image = maps.get("image");

//        System.out.println(name);
//        System.out.println(writer);
//        System.out.println(price);
//        System.out.println(isbn);
//        System.out.println(inventory);
//        System.out.println(image);

        Book book = new Book();
        book.setName(name);
        book.setWriter(writer);
        book.setISBN(isbn);
        book.setPrice(price);
        book.setInventory(inventory);

        BookImage bi = new BookImage();
        bi.setImage(image);

        bd.storeNewBook(book, bi);
    }

    @Override
    public void modifyBooks(List<Map<String, String>> maps){
        try{
            for(Map<String, String> map:maps){
                Long id = Long.parseLong(map.get("bookId"));
                String name = map.get("name");
                String writer = map.get("writer");
                int price = Integer.parseInt(map.get("price"));
                String isbn = map.get("isbn");
                int inventory = Integer.parseInt(map.get("inventory"));

                bd.modifyOneBook(id, name, writer, price, isbn, inventory);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeBooks(List<Long> ids){ bd.removeBook(ids); }
}