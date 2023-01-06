package com.reactivespring.reactivespringwebclient.controller;


import com.reactivespring.reactivespringwebclient.model.BookRequest;
import com.reactivespring.reactivespringwebclient.model.BookResponse;
import com.reactivespring.reactivespringwebclient.service.BookService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/getBooks")
    public Flux<BookRequest> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/getBooks/{bookId}")
    public Mono<BookRequest> getBookById(@PathVariable int bookId){
        return this.bookService.getBookById(bookId);
    }

    @PostMapping("/postBook")
    public Mono<BookResponse> createBook(@RequestBody Mono<BookRequest> bookRequestMono){
        return this.bookService.createBook(bookRequestMono);
    }
}
