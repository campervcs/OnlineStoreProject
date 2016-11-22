package model.customer;

public class Customer {
    private String fname;
    private String lname;
    private String mail;
    private String username;
    private String password;
    private Role role;
    private Cart cart;

    public Customer(String mail, String username, String password, Role role) {
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

    public void setRole(Role role) {
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

    public Role getRole() {
        return this.role;
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
