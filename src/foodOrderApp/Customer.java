package foodOrderApp;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jayo
 */
public class Customer {
    
    private String username, passwrod, email, phonenumber;

    public Customer(String username, String passwrod) {
        this.username = username;
        this.passwrod = passwrod;
    }

    public Customer(String username, String passwrod, String email, String phonenumber) {
        this.username = username;
        this.passwrod = passwrod;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    

  
}
