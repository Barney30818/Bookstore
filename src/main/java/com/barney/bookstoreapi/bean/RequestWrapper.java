package com.barney.bookstoreapi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestWrapper<T> {

    T model;
}
