package com.umaxcode.spring.boot.with.graphql.services;


import com.umaxcode.spring.boot.with.graphql.entities.Book;
import com.umaxcode.spring.boot.with.graphql.exceptions.custom.BookException;
import com.umaxcode.spring.boot.with.graphql.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }

        throw new BookException(HttpStatus.BAD_REQUEST, String.format("A book with the id = %s does not exist.", id));
    }

    public Book update(Book book){

        if(book.getTitle() != null || book.getPageCount() != null){
            var seachBook = findById(book.getId());
            if(book.getTitle() != null){
                seachBook.setTitle(book.getTitle());
            }

            if(book.getPageCount() != null){
                seachBook.setPageCount(book.getPageCount());
            }

            return save(seachBook);
        }

        throw new BookException(HttpStatus.BAD_REQUEST, "An update wasn't made");
    }

    public void destroy(Integer id){
        Book book = findById(id);
        bookRepository.delete(book);
    }

}
