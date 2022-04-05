package com.barney.bookstoreapi.controller;

import com.barney.bookstoreapi.bean.BookVO;
import com.barney.bookstoreapi.bean.RequestWrapper;
import com.barney.bookstoreapi.bean.ResponseHeader;
import com.barney.bookstoreapi.bean.ResponseWrapper;
import com.barney.bookstoreapi.repository.BookstoreDAO;
import com.barney.bookstoreapi.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    //新增書籍API
    @PostMapping("/barney/createBook")
    public @ResponseBody ResponseWrapper<String> createBook(@RequestBody RequestWrapper<BookVO> requestObject) throws Exception {
        BookVO bookVO = requestObject.getModel();
        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            bookstoreService.createBook(bookVO);
            responseHeader.setErrorCode("0000");
            responseHeader.setErrorDesc("新增成功");
            responseWrapper.setModel("");
        }catch (Exception e){
            responseHeader.setErrorCode("9999");
            responseHeader.setErrorDesc(e.getMessage());
        }
        responseWrapper.setHeader(responseHeader);

        return responseWrapper;
    }
    
    //更新書籍API
    @PostMapping("/barney/updateBook")
    public @ResponseBody ResponseWrapper<String> updateBook(@RequestBody RequestWrapper<BookVO> requestObject) throws Exception {
        //假設用此API做更新仍傳遞整個BookVO物件，欲更新欄位已在物件內更改
        BookVO bookVO = requestObject.getModel();
        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            String resultMessage = bookstoreService.updateBookInfo(bookVO);
            responseHeader.setErrorCode("0000");
            responseHeader.setErrorCode("更新成功");
            responseWrapper.setModel("");
        }catch (Exception e){
            responseHeader.setErrorCode("9999");
            responseHeader.setErrorDesc(e.getMessage());
        }
        responseWrapper.setHeader(responseHeader);

        return responseWrapper;
    }

    //查詢全部書籍API
    @PostMapping("/barney/searchAllBook")
    public @ResponseBody ResponseWrapper<List<BookVO>> searchAllBook() throws Exception {
        ResponseWrapper<List<BookVO>> responseWrapper = new ResponseWrapper<>();
        ResponseHeader responseHeader = new ResponseHeader();
        List<BookVO> bookVOList = new ArrayList<>();
        try {
            bookVOList = bookstoreService.searchAllBook();
            responseHeader.setErrorCode("0000");
            responseHeader.setErrorCode("查詢成功");
        }catch (Exception e){
            responseHeader.setErrorCode("9999");
            responseHeader.setErrorCode("查詢失敗");
        }
        responseWrapper.setHeader(responseHeader);
        responseWrapper.setModel(bookVOList);

        return responseWrapper;
    }

    //刪除書籍API
    @PostMapping("/barney/deleteBook")
    public @ResponseBody ResponseWrapper<String> deleteBook(@RequestBody RequestWrapper<String> requestObject) throws Exception {
        String oid = requestObject.getModel();
        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
        	String resultMessage = bookstoreService.deleteBook(oid);
            responseHeader.setErrorCode("0000");
            responseHeader.setErrorCode("刪除成功");
            responseWrapper.setModel("");
        }catch (Exception e){
            responseHeader.setErrorCode("9999");
            responseHeader.setErrorDesc(e.getMessage());
        }
        responseWrapper.setHeader(responseHeader);

        return responseWrapper;
    }

    //測試API用
    @GetMapping(path = "/v1/barney")
    public BookVO hello() {
        BookVO bookVO = new BookVO(
                "Quick Learn JAVA",
                "baney",
                "barney",
                "978‑0 978‑1",
                "company",
                "2022/03/25",
                300
        );
        return bookVO;
    }
}
