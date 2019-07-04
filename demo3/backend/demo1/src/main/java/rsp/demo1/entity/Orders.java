package rsp.demo1.entity;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(appliesTo = "orders")
public class Orders {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private User user;

    @OneToMany(targetEntity = OrderItem.class, mappedBy = "orderID",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Basic
    @Column
    private double value;

    @Basic
    @Column
    private boolean paied;

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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public boolean isPaied() {
        return paied;
    }

    public void setPaied(boolean paied) {
        this.paied = paied;
    }

}
