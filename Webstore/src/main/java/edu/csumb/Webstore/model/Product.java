//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;
import org.springframework.data.annotation.Id;

public class Product
{
    @Id
    private String id;
    private String image;
    private String desc;
    private Double price;
    private Integer stock;

    public String getID(){
        return this.id;
    }

    public void setID(Integer id){
      this.id = id.toString();
    }

    public String getImage(){
      return this.image;
    }

    public void setImage(String image){
      this.image = image;
    }

    public String getDesc(){
      return this.desc;
    }

    public void setDesc(String desc){
      this.desc = desc;
    }

    public Double getPrice(){
      return this.price;
    }

    public void setPrice(Double price){
      this.price = price;
    }

    public Integer getStock(){
      return this.stock;
    }

    public void setStock(Integer stock){
      this.stock = stock;
    }

}
