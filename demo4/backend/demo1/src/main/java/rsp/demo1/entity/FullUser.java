package rsp.demo1.entity;

public class FullUser {
    private Long userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String image;

    public FullUser(Long userId, String firstname, String lastname, String email, String password, String image){
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.image = image;
    }
    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
