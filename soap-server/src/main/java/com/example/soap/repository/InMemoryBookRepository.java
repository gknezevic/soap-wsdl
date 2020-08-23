package com.example.soap.repository;

import io.spring.guides.gs_producing_web_service.Author;
import io.spring.guides.gs_producing_web_service.Book;
import io.spring.guides.gs_producing_web_service.Language;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryBookRepository {

    private Map<String, Book> books = new HashMap<>();

    @PostConstruct
    public void initData() {
        Author author1 = new Author();
        author1.setFirstName("Charles");
        author1.setLastName("Bukowski");
        author1.setBiography("Poet and novelist");
        Book book1 = new Book();
        book1.setIsbn("11-22");
        book1.setAuthor(author1);
        book1.setTitle("Pulp");
        book1.setLanguage(Language.ENG);
        book1.setCopies(500);

        Book book2 = new Book();
        book2.setIsbn("987");
        book2.setTitle("Hollywood");
        book2.setAuthor(author1);
        book2.setLanguage(Language.ENG);
        book2.setCopies(1000);

        books.put(book1.getIsbn(), book1);
        books.put(book2.getIsbn(), book2);
    }

    public Book findByIsbn(String isbn) {
        return books.get(isbn);
    }
}
