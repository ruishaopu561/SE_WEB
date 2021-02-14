package rsp.ebook.entity;

import javax.persistence.*;
import org.hibernate.annotations.Table;

@Entity(name = "items")
@Table(appliesTo = "items")
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "orderId")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;

    @Column
    private int amount;

    @Column
    private double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAmount() {
        return amount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
