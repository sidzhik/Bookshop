package com.siedge.app.Bookshop.Models;


import javax.persistence.*;

// this annotation is bean type for notice that we have to create a table in our database like object...
@Entity
public class BooksBerezovskyi {

    //.. with next data
    @Id // mark id variable like KEY for each book
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for any next added book id will increment
    private long id;

    // mark column via column annotation for our books
    @Column
    private String titleBerezovskyi;

    @Column
    private String authorBerezovskyi;

    @Column
    private int quantityBerezovskyi;

    @Column
    private int priceBerezovskyi;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitleBerezovskyi() {
        return titleBerezovskyi;
    }

    public void setTitleBerezovskyi(String titleBerezovskyi) {
        this.titleBerezovskyi = titleBerezovskyi;
    }

    public String getAuthorBerezovskyi() {
        return authorBerezovskyi;
    }

    public void setAuthorBerezovskyi(String authorBerezovskyi) {
        this.authorBerezovskyi = authorBerezovskyi;
    }

    public int getQuantityBerezovskyi() {
        return quantityBerezovskyi;
    }

    public void setQuantityBerezovskyi(int quantityBerezovskyi) {
        this.quantityBerezovskyi = quantityBerezovskyi;
    }

    public int getPriceBerezovskyi() {
        return priceBerezovskyi;
    }

    public void setPriceBerezovskyi(int priceBerezovskyi) {
        this.priceBerezovskyi = priceBerezovskyi;
    }
}
