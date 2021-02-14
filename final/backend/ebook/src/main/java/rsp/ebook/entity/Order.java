package rsp.ebook.entity;

import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Table;

@Entity(name = "orders")
@Table(appliesTo = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @OneToMany(targetEntity = Item.class, mappedBy = "orderId",cascade = CascadeType.ALL)
    private List<Item> items;

    @Basic
    @Column
    private double value;

    @Basic
    @Column
    private boolean paied;

    @Basic
    @Column
    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<Item> getOrderItems() {
        return items;
    }

    public void setOrderItems(List<Item> items) {
        this.items = items;
    }

    public boolean isPaied() {
        return paied;
    }

    public void setPaied(boolean paied) {
        this.paied = paied;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
