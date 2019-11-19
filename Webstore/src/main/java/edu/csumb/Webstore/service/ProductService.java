//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.ProductRepository;

//Remember to annotate what type of class this is!
@Service
public class ProductService
{
    //We need to autowire the database here. If you are stuck, look at ProductController!
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product){
        productRepository.insert(product);
        return product;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getByID(String id){
      Optional<Product> product = productRepository.findById(id);
      if(product.isPresent()){
        return product.get();
      }
       return null;
    }
}
