package com.arad4228Leaned.arad4228.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String context;

    @Builder
    public PostsUpdateRequestDto(String title, String context){
        this.title = title;
        this.context = context;
    }

}
