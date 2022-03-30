package com.barney.bookstoreapi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseWrapper<T> {

    ResponseHeader header;

    T model;
}
