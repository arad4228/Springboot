package com.arad4228Leaned.arad4228.web.dto;

import com.arad4228Leaned.arad4228.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String context;
    private String author;

    public PostsResponseDto(Posts entity)
    {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.context = entity.getContext();
        this.author = entity.getAuthor();
    }
}
