package com.umaxcode.spring.boot.with.graphql.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private Integer pageCount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Author author;
}
