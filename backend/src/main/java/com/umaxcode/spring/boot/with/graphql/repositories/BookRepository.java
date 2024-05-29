package com.umaxcode.spring.boot.with.graphql.repositories;

import com.umaxcode.spring.boot.with.graphql.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
