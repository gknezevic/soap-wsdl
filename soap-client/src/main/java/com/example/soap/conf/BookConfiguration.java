package com.example.soap.conf;

import com.example.soap.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BookConfiguration {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.example.generated.wsdl");
        return jaxb2Marshaller;
    }

    @Bean
    public BookService bookService(Jaxb2Marshaller marshaller) {
        BookService bookService = new BookService();
        bookService.setDefaultUri("http://localhost:8080/ws");
        bookService.setMarshaller(marshaller);
        bookService.setUnmarshaller(marshaller);
        return bookService;
    }
}
