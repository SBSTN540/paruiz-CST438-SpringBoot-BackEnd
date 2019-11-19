package edu.csumb.Webstore.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.repositories.UserRepository;
import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.ProductRepository;
import java.util.HashMap;


//Remember to annotate what type of class this is!
@Service
public class UserService
{
    //We need to autowire the database here. If you are stuck, look at ProductController!
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    public boolean createUser(User user){
        userRepository.insert(user);
        return true;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getByID(String id){
      Optional<User> user = userRepository.findById(id);
      if(user.isPresent()){
        return user.get();
      }
       return null;
    }

    public Boolean userLogin(String email, String password){
      Optional<User> user = userRepository.findById(email);
      if(user.isPresent()){
         if(user.get().getPassword().equals(password)) return true;
      }
        return false;
    }

    public Boolean cartUpdate(String email, String id, Integer amnt){
      Optional<User> user = userRepository.findById(email);
      Optional<Product> product = productRepository.findById(id);
      if(user.isPresent() && product.isPresent()){
         HashMap<String, Integer> tempCart = user.get().getCart();
         tempCart.put(id, amnt);
         user.get().setCart(tempCart);
         userRepository.save(user.get());
         return true;
       }
      return false;
    }

    public Boolean cartCheckout(String email){
        Optional<User> user = userRepository.findById(email);
        if(user.isPresent()){
          HashMap<String, Integer> tempCart = user.get().getCart();
          for (String key : tempCart.keySet()) {
               Optional<Product> product = productRepository.findById(key);
               if(product.isPresent()){
                 product.get().setStock( Integer.valueOf(  product.get().getStock().intValue() - tempCart.get(key).intValue() ));
                 productRepository.save(product.get());
               }
               tempCart.remove(key);
          }
          user.get().setCart(tempCart);
          userRepository.save(user.get());
          return true;
        }
        return false;
    }


}
