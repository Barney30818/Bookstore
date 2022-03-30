package com.barney.bookstoreapi.repository;

import com.barney.bookstoreapi.bean.BookVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookstoreDAOImpl implements BookstoreDAO{
    @Override
    public void createBook(BookVO bookVO) {

    }

    @Override
    public String updateBookInfo(BookVO bookVO) {
        return null;
    }

    @Override
    public List<BookVO> searchAllBook() {
        return null;
    }

    @Override
    public String deleteBook(String ISBN) {
        return null;
    }
}
