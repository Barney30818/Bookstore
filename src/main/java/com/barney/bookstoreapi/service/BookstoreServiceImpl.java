package com.barney.bookstoreapi.service;

import com.barney.bookstoreapi.bean.BookVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.barney.bookstoreapi.repository.BookstoreDAO;

import java.util.List;

@Service
public class BookstoreServiceImpl implements BookstoreService{
	
	@Autowired
	private BookstoreDAO bookstoreDAO;
	
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
    
    //test用
    @Override
    public void save(BookVO bookVO) {
    	bookstoreDAO.createBook(bookVO);
    }
}
