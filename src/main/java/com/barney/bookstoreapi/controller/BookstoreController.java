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

    @RequestMapping(value = "/barney/createBook",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public @ResponseBody ResponseWrapper<String> createBook(@RequestBody RequestWrapper<BookVO> requestObject) {
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
