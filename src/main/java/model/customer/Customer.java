package model.customer;

public class Customer {

    private static int id=0;
    private final int curID;
    private String fname;
    private String lname;
    private String mail;
    private String password;
    private String role;

    public Customer(String mail, String password, String role) {
        this.mail = mail;
        this.password = password;
        this.role=role;
        curID=id;
        id++;
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

    public int getID() {
        return curID;
    }

}
