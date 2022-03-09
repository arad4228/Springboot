package com.arad4228Leaned.arad4228.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    // Pk의 역할
    @Id
    // Auto Increment를 한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500, nullable = false)
    private  String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String context;

    private String author;

    @Builder
    public Posts(String title, String context, String author) {
        this.title = title;
        this.context = context;
        this.author = author;
    }
}

