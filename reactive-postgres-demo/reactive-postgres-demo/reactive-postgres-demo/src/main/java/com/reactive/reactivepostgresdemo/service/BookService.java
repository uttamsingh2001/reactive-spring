package com.reactive.reactivepostgresdemo.service;
import com.reactive.reactivepostgresdemo.mapper.BookMapper;
import com.reactive.reactivepostgresdemo.model.BookRequest;
import com.reactive.reactivepostgresdemo.model.BookResponse;
import com.reactive.reactivepostgresdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Mono<BookResponse> createBook(Mono<BookRequest> bookRequestMono){
           return bookRequestMono.map(bookMapper::modeltoentity)
                                  .flatMap(this.bookRepository::save)
                                  .map(bookMapper::enitityToModel1);
    }

    public Flux<BookRequest> getAllBooks() {
        return this.bookRepository.findAll()
                .map(bookMapper::enitityToModel);
    }

    public Mono<BookRequest> getBookById(int bookId) {
        return this.bookRepository.findById(bookId)
                .map(bookMapper::enitityToModel);
    }

    public Mono<BookRequest> updateBook(int bookId, Mono<BookRequest> bookRequest) {
        return this.bookRepository.findById(bookId)
                .flatMap(u->bookRequest.map(bookMapper::modeltoentity)
                        .doOnNext(e->e.setBookId(bookId))).flatMap(bookRepository::save)
                .map(bookMapper::enitityToModel);

    }

    public Mono<Void> deleteProduct(int bookId) {
        return bookRepository.deleteById(bookId);
    }
}
