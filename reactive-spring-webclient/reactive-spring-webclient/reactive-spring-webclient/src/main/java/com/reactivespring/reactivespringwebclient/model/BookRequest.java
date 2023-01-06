package com.reactivespring.reactivespringwebclient.model;

import lombok.Data;
import lombok.ToString;

@Data
public class BookRequest extends BookResponse {
    private String bookName;
    private String bookAuthor;

}
