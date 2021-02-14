package rsp.ebook.entity;

import javax.persistence.*;
import org.hibernate.annotations.Table;

@Entity(name = "books")
@Table(appliesTo = "books")
public class Book {

    @Id
    @GeneratedValue
    public Long id;

    @Column
    private String name;

    @Column
    private String writer;

    @Column
    private String ISBN;

    @Column
    private int price;

    @Column
    private int inventory;

    public Book() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

}
