package com.example.ecommerceapp.Domain;

import java.io.Serializable;

public class itemsDomain  implements Serializable {
    private String ImgPath ;
    private  String title ;
    private double price ;
    private String description ;
   private double rate ;

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String imgPath) {
        ImgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public itemsDomain(String imgPath, String title, double price, String description, double rate) {
        ImgPath = imgPath;
        this.title = title;
        this.price = price;
        this.description = description;
        this.rate = rate;
    }
}
