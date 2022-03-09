package com.arad4228Leaned.arad4228.web.dto;

import com.arad4228Leaned.arad4228.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String context;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String context, String author) {
        this.title = title;
        this.context = context;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .context(context)
                .author(author)
                .build();
    }
}
