package com.barney.bookstoreapi.bean;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "BOOK_INFO")
@Data
public class BookVO {

    //private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
    @Column(name = "OID")
    private String OID;


    @Column(name="ISBN")
    private String ISBN;
    @Column(name="BOOK_NAME")
    private String bookName;
    @Column(name="AUTHOR")
    private String author;
    @Column(name="TRANSLATOR")
    private String translator;
    @Column(name="PUBLISHER")
    private String publisher;
    @Column(name="PUBLISHDATE")
    private String publishDate;
    @Column(name="PRICE")
    private Integer price;

    public BookVO(String bookName, String author, String translator, String ISBN, String publisher, String publishDate, Integer price) {
        this.bookName = bookName;
        this.author = author;
        this.translator = translator;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.price = price;
    }

    public BookVO() {

    }
}

