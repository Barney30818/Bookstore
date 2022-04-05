package com.barney.bookstoreapi.repository;

import com.barney.bookstoreapi.bean.BookVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookstoreDAO extends CrudRepository<BookVO, String>{
    /*
    不用實作任何方法，即可直接用CrudRepository提供的方法
     */
}
