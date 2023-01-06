package com.reactive.reactivepostgresdemo.controller;
import com.reactive.reactivepostgresdemo.model.BookRequest;
import com.reactive.reactivepostgresdemo.model.BookResponse;
import com.reactive.reactivepostgresdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Mono<BookResponse> createBook(@RequestBody Mono<BookRequest> bookRequestMono){
        return this.bookService.createBook(bookRequestMono);
    }

    @GetMapping
    public Flux<BookRequest> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Mono<BookRequest> getBookById(@PathVariable int bookId){
        return this.bookService.getBookById(bookId);
    }

    @PutMapping("/{bookId}")
    public Mono<BookRequest> updateBook(@PathVariable int bookId,@RequestBody Mono<BookRequest> bookRequest){
        return this.bookService.updateBook(bookId,bookRequest);
    }

    @DeleteMapping("/{bookId}")
    public Mono<Void> deleteBook(@PathVariable int bookId) {
        return bookService.deleteProduct(bookId);
    }




}
