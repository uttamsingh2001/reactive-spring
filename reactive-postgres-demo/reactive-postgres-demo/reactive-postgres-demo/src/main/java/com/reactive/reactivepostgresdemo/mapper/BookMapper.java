package com.reactive.reactivepostgresdemo.mapper;


import com.reactive.reactivepostgresdemo.entity.BookEntity;
import com.reactive.reactivepostgresdemo.model.BookRequest;
import com.reactive.reactivepostgresdemo.model.BookResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface BookMapper {

    BookEntity modeltoentity(BookRequest bookRequest);

    BookRequest enitityToModel(BookEntity bookEntity);

    BookResponse enitityToModel1(BookEntity bookEntity);

}
