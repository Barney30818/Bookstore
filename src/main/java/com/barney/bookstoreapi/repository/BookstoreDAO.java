package com.barney.bookstoreapi.repository;

import com.barney.bookstoreapi.bean.BookVO;

import java.util.List;

public interface BookstoreDAO {

    void createBook(BookVO bookVO);

    String updateBookInfo(BookVO bookVO);

    List<BookVO> searchAllBook();

    String deleteBook(String ISBN);
}
