package rsp.demo1.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderitem")
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "orderID")
    private Long orderID;

    @ManyToOne
    @JoinColumn(name = "bookID", referencedColumnName = "id")
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

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }
}
