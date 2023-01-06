package com.reactive.reactivepostgresdemo.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table(name="books")
public class BookEntity  {
    @Id
    @Column("book_id")
    private int bookId;

    @Column("book_name")
    private String bookName;

    @Column("book_author")
    private String bookAuthor;
}
