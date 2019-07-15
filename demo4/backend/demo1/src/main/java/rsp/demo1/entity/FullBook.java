package rsp.demo1.entity;

public class FullBook {

    private Long bookId;
    private String name;
    private String writer;
    private String isbn;
    private int price;
    private int inventory;
    private String image;

    public FullBook(Long bookId, String name, String writer, String ISBN, int price, int inventory, String image){
        this.bookId = bookId;
        this.name =  name;
        this.writer = writer;
        this.isbn =  ISBN;
        this.price =  price;
        this.inventory =  inventory;
        this.image = image;

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
