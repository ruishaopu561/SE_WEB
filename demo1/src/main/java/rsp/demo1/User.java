package rsp.demo1;

public class User {
    String firstname;
    String lastname;
    String email;
    String password;

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    private void setFirstname(String firstname){
        this.firstname = firstname;
    }

    private void setLastname(String lastname){
        this.lastname = lastname;
    }

    private void setEmail(String email){
        this.email = email;
    }

    private void setPassword(String password)
    {
        this.password = password;
    }
}
