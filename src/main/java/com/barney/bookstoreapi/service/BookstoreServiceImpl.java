package com.barney.bookstoreapi.service;

import com.barney.bookstoreapi.bean.BookVO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.barney.bookstoreapi.repository.BookstoreDAO;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookstoreServiceImpl implements BookstoreService{

    @Autowired
    private BookstoreDAO bookstoreDAO;
	
    @Override
    public void createBook(BookVO bookVO) throws Exception {
        try {
            //檢核每個欄位為必填
            isEmpty(bookVO.getBookName(),"bookName");
            isEmpty(bookVO.getISBN(),"ISBN");
            isEmpty(bookVO.getTranslator(),"translator");
            isEmpty(bookVO.getAuthor(),"author");
            isEmpty(bookVO.getPublisher(),"publisher");
            isEmpty(bookVO.getPublishDate(),"publishDate");
            isEmpty(bookVO.getPrice(),"price");

            //先找出資料庫既有案件的總數量，再+1為新的oid
            List<BookVO> ExistBookVOList = bookstoreDAO.findAll();
            int currSize = ExistBookVOList.size();
            bookVO.setOID(Integer.toString(currSize+1));

            bookstoreDAO.save(bookVO);
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String updateBookInfo(BookVO bookVO) throws Exception {
        try {
            //檢核每個欄位為必填
            isEmpty(bookVO.getBookName(), "bookName");
            isEmpty(bookVO.getISBN(), "ISBN");
            isEmpty(bookVO.getTranslator(), "translator");
            isEmpty(bookVO.getAuthor(), "author");
            isEmpty(bookVO.getPublisher(), "publisher");
            isEmpty(bookVO.getPublishDate(), "publishDate");
            isEmpty(bookVO.getPrice(), "price");

            //CrudRepository的save方法會依照db中的id是否存在，若存在則更新
            bookstoreDAO.save(bookVO);
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    @Override
    public List<BookVO> searchAllBook() throws Exception {
        List<BookVO> BookVOList = new ArrayList<>();
        try {
            BookVOList = bookstoreDAO.findAll();
        } catch (Exception e) {
            throw e;
        }
        return BookVOList;
    }

    @Override
    public String deleteBook(String oid) throws Exception {
        try {
            bookstoreDAO.deleteById(oid);
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    private <T> void isEmpty(T value,String columnName) throws Exception {
        if(null==value || "".equals(value)){
            throw new Exception("<"+columnName+">"+"欄位不能為空");
        }
    }
}
