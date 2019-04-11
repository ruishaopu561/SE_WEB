package rsp.demo1;

public class Book {
    String name;
    String writer;
    Integer price;
    String isbn;
    String inventory;

    public String getName() {
        return name;
    }

    public String getWriter(){
        return writer;
    }

    public String getIsbn(){
        return isbn;
    }

    public int getPrice(){
        return price;
    }

    public String getInventory(){
        return inventory;
    }

    public void setName(String name){
        this.name = name;
    }

    public  void setWriter(String writer){
        this.writer = writer;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public void setInventory(String inventory){
        this.inventory = inventory;
    }
}
