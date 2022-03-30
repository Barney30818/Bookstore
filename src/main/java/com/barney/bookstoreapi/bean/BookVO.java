package com.barney.bookstoreapi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BookVO {

    private static final long serialVersionUID = 1L;

    private String bookName;

    private String author;

    private String translator;

    private String ISBN;

    private String publisher;

    private String publishDate;

    private BigDecimal price;

    public BookVO(String bookName, String author, String translator, String ISBN, String publisher, String publishDate, int price) {
        this.bookName = bookName;
        this.author = author;
        this.translator = translator;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = BigDecimal.valueOf(price);
    }
}

