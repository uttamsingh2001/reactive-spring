package com.reactivespring.reactivespringwebclient.service;


import com.reactivespring.reactivespringwebclient.model.BookRequest;
import com.reactivespring.reactivespringwebclient.model.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    @Value("${baseUrl}")
    private String baseUrl;
    private final WebClient webClient;

    @Autowired
    public BookService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<BookRequest> getAllBooks() {
        return webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToFlux(BookRequest.class);
    }

    public Mono<BookRequest> getBookById(int bookId) {
        return webClient.get()
                .uri(baseUrl + "/" + bookId)
                .retrieve()
                .bodyToMono(BookRequest.class);
    }

    public Mono<BookResponse> createBook(Mono<BookRequest> bookRequestMono) {
        return webClient.post()
                .uri(baseUrl)
                .body(Mono.just(bookRequestMono), BookRequest.class)
                .retrieve()
                .bodyToMono(BookResponse.class);
    }
}
