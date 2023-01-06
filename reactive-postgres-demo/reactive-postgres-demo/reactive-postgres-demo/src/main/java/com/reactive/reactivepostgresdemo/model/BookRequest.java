package com.reactive.reactivepostgresdemo.model;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BookRequest extends BookResponse {
    private String bookName;
    private String bookAuthor;

}
