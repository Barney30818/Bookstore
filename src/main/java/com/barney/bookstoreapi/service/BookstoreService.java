package com.barney.bookstoreapi.service;

import com.barney.bookstoreapi.bean.BookVO;

import java.util.List;

public interface BookstoreService {

    void createBook(BookVO bookVO);

    String updateBookInfo(BookVO bookVO);

    List<BookVO> searchAllBook();

    String deleteBook(String ISBN);
}
