package com.example.soap.service;

import com.example.soap.repository.InMemoryBookRepository;
import io.spring.guides.gs_producing_web_service.GetBookRequest;
import io.spring.guides.gs_producing_web_service.GetBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookService {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private InMemoryBookRepository bookRepository;

    @Autowired
    public BookService(InMemoryBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PayloadRoot(localPart = "getBookRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) {
        GetBookResponse response = new GetBookResponse();
        response.setBook(bookRepository.findByIsbn(request.getIsbn()));
        return response;
    }
}
