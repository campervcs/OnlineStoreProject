package model.customer;

public class Customer {
    private String fname;
    private String lname;
    private String mail;
    private String username;
    private String password;
    private String role;
    private Cart cart;

    public Customer(String mail, String username, String password, String role) {
        cart = new Cart();
        this.mail = mail;
        this.password = password;
        this.role=role;
        this.username=username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Cart getCart() {
        return cart;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
