package com.example.soap;

import com.example.generated.wsdl.GetBookResponse;
import com.example.soap.service.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapApplication.class, args);
    }

    @Bean
    ApplicationRunner getBooks(BookService bookService) {
        return args -> {
            GetBookResponse bookResponse = bookService.getBook("987");
            System.out.println("Fetched book: " + bookResponse.getBook().getTitle());
        };
    }

}
