package com.arad4228Leaned.arad4228.service.posts;

import com.arad4228Leaned.arad4228.domain.posts.PostsRepository;
import com.arad4228Leaned.arad4228.web.PostsApiController;
import com.arad4228Leaned.arad4228.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
