package rsp.demo1.module;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(appliesTo = "cart")
public class Cart {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String useremail;

    @Column
    private String bookname;

    @Column
    private int amount;

    @Column
    private boolean paied;

    public Cart(){
    }

    public boolean isPaied() {
        return paied;
    }

    public void setPaied(boolean paied) {
        this.paied = paied;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
