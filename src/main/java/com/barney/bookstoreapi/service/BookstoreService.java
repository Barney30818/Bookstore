package com.barney.bookstoreapi.service;

import com.barney.bookstoreapi.bean.BookVO;

import java.util.List;

public interface BookstoreService {

    void createBook(BookVO bookVO) throws Exception ;

    String updateBookInfo(BookVO bookVO) throws Exception ;

    List<BookVO> searchAllBook() throws Exception ;

    String deleteBook(String oid) throws Exception ;
}
