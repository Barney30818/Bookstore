package com.barney.bookstoreapi;

import com.barney.bookstoreapi.bean.BookVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class BookstoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApiApplication.class, args);
	}

}
