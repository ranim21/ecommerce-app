package com.example.ecommerceapp.Domain;

public class CategoryDomain {
private String imParg ;

    public CategoryDomain(String imParg, String title) {
        this.imParg = imParg;
        this.title = title;
    }

    public String getImParg() {
        return imParg;
    }

    public void setImParg(String imParg) {
        this.imParg = imParg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title ;

}
