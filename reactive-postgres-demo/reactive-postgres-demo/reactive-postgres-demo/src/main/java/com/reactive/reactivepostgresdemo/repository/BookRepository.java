package com.reactive.reactivepostgresdemo.repository;

import com.reactive.reactivepostgresdemo.entity.BookEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveCrudRepository<BookEntity,Integer> {

}
