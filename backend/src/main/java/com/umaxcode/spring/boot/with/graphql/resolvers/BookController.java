package com.umaxcode.spring.boot.with.graphql.resolvers;

import com.umaxcode.spring.boot.with.graphql.dtos.BookRequest;
import com.umaxcode.spring.boot.with.graphql.entities.Book;
import com.umaxcode.spring.boot.with.graphql.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @QueryMapping
    public Book getBookById(@Argument Integer id) {
        return bookService.findById(id);
    }

    @MutationMapping
    public Book addBook(@Argument BookRequest request) {
        return bookService.save(Book.builder()
                .title(request.title())
                .pageCount(request.pageCount())
                .build());
    }

    @MutationMapping
    public Book updateBook(@Argument Book request) {

        return bookService.update(Book.builder()
                .id(request.getId())
                .title(request.getTitle())
                .pageCount(request.getPageCount())
                .build());
    }

    @MutationMapping
    public String deleteBook(@Argument Integer id) {
        bookService.destroy(id);
        return String.format("book with id '%d' deleted", id);
    }
}
