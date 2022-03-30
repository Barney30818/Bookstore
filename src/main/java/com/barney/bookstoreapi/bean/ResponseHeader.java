package com.barney.bookstoreapi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseHeader {

    private String errorCode; //結果代碼

    private String errorDesc; //結果訊息
}
