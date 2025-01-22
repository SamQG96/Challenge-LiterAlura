package com.aluracursos.literalura.service;

import com.aluracursos.literalura.model.Author;
import com.aluracursos.literalura.model.Book;
import com.aluracursos.literalura.model.SearchResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private static final String BASE_URL = "https://gutendex.com/books";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;



    @Autowired
    public BookService(RestTemplate restTemplate, ObjectMapper objectMapper, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book saveBook(Book book) {
        List<Author> authors = book.getAuthors();
        if (authors != null) {
            // Guardar o actualizar cada autor en la lista
            authors = authors.stream()
                    .map(authorRepository::save)
                    .toList();
            book.setAuthors(authors);
        }
        return bookRepository.save(book);
    }


    public List<Book> searchBooks(Map<String, String> params) {
        // Construir la URL con los parámetros
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://gutendex.com/books");
        params.forEach(builder::queryParam);
        URI uri = builder.build().toUri();

        // Realizar la solicitud y mapear la respuesta a una lista de Book
        ResponseEntity<SearchResponse> response = restTemplate.getForEntity(uri, SearchResponse.class);
        return response.getBody().getResults();
    }

    public List<Book> searchBooksByTitle(String title) {
        return searchBooks(Map.of("search", title));
    }

    public List<Book> searchBooksByAuthor(String author) {
        return searchBooks(Map.of("authors", author));
    }

    public List<Book> searchBooksByLanguage(String language) {
        return searchBooks(Map.of("languages", language));
    }

    public List<Book> getAllBooks() {
        return searchBooks(Map.of()); // No se envían parámetros para obtener todos los libros
    }
    }
