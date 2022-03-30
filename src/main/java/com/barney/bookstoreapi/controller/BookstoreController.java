package com.barney.bookstoreapi.controller;

import com.barney.bookstoreapi.bean.BookVO;
import com.barney.bookstoreapi.bean.RequestWrapper;
import com.barney.bookstoreapi.bean.ResponseHeader;
import com.barney.bookstoreapi.bean.ResponseWrapper;
import com.barney.bookstoreapi.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
            responseHeader.setErrorCode("新增成功");
        }catch (Exception e){
            responseHeader.setErrorCode("9999");
            responseHeader.setErrorCode("新增失敗");
        }
        responseWrapper.setHeader(responseHeader);
        responseWrapper.setModel("success");

        return responseWrapper;
    }
    
//    //更新書籍API
//    @PostMapping("/barney/updateBook")
//    public @ResponseBody ResponseWrapper<String> updateBook(@RequestBody RequestWrapper<BookVO> requestObject) throws Exception {
//        BookVO bookVO = requestObject.getModel();
//        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>();
//        ResponseHeader responseHeader = new ResponseHeader();
//        try {
//            String resultMessage = bookstoreService.updateBook(bookVO);
//            responseHeader.setErrorCode("0000");
//            responseHeader.setErrorCode("新增成功");
//        }catch (Exception e){
//            responseHeader.setErrorCode("9999");
//            responseHeader.setErrorCode("新增失敗");
//        }
//        responseWrapper.setHeader(responseHeader);
//        responseWrapper.setModel(resultMessage);
//
//        return responseWrapper;
//    }
//    
//    //查詢全部書籍API
//    @PostMapping("/barney/searchAllBook")
//    public @ResponseBody ResponseWrapper<List<BookVO>> searchAllBook() throws Exception {
//        ResponseWrapper<List<BookVO>> responseWrapper = new ResponseWrapper<>();
//        ResponseHeader responseHeader = new ResponseHeader();
//        try {
//            List<BookVO> bookVOList = bookstoreService.searchAllBook();
//            responseHeader.setErrorCode("0000");
//            responseHeader.setErrorCode("新增成功");
//        }catch (Exception e){
//            responseHeader.setErrorCode("9999");
//            responseHeader.setErrorCode("新增失敗");
//        }
//        responseWrapper.setHeader(responseHeader);
//        responseWrapper.setModel(bookVOList);
//
//        return responseWrapper;
//    }
//    
//    //刪除書籍API
//    @PostMapping("/barney/deleteBook")
//    public @ResponseBody ResponseWrapper<String> deleteBook(@RequestBody RequestWrapper<String> requestObject) throws Exception {
//        String ISBN = requestObject.getModel();
//        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>();
//        ResponseHeader responseHeader = new ResponseHeader();
//        try {
//        	String resultMessage = bookstoreService.deleteBook(ISBN);
//            responseHeader.setErrorCode("0000");
//            responseHeader.setErrorCode("新增成功");
//        }catch (Exception e){
//            responseHeader.setErrorCode("9999");
//            responseHeader.setErrorCode("新增失敗");
//        }
//        responseWrapper.setHeader(responseHeader);
//        responseWrapper.setModel(resultMessage);
//
//        return responseWrapper;
//    }

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

    @GetMapping("/v2/barney")
    public String hey() {
        return new String("123");
    }
}
