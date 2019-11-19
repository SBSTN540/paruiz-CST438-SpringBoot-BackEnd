//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;
import org.springframework.data.annotation.Id;
import java.util.HashMap;

public class User
{
    @Id
    private String email;
    private String password;
    private HashMap<String, Integer> cart;

    public User(){
      cart = new HashMap<String, Integer>();
    }

    public String getEmail(){
      return this.email;
    }
    public void setEmail(String email){
      this.email = email;
    }
    public String getPassword(){
      return this.password;
    }
    public void setPassword(String password){
      this.password = password;
    }
    public HashMap<String, Integer> getCart(){
      return this.cart;
    }
    public void setCart(HashMap<String, Integer> cart){
      this.cart = cart;
    }
}
