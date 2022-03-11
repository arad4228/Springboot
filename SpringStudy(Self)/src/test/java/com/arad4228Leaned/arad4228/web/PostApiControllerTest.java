package com.arad4228Leaned.arad4228.web;

import com.arad4228Leaned.arad4228.domain.posts.Posts;
import com.arad4228Leaned.arad4228.domain.posts.PostsRepository;
import com.arad4228Leaned.arad4228.web.dto.PostsSaveRequestDto;
import com.arad4228Leaned.arad4228.web.dto.PostsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception {
        // given
        String title = "tile";
        String context = "context";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .context(context)
                .author("author")
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).
                isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContext()).isEqualTo(context);
    }

    @Test
    public void Posts_수정된다() throws Exception {
        // given
        Posts savePosts = postsRepository.save(Posts.builder()
                .title("title")
                .context("Context")
                .author("author")
                .build());

        Long updateID = savePosts.getId();
        String expectTitle = "title2";
        String expectContext = "Context2";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title(expectTitle)
                .context(expectContext)
                .build();
        String url = "http://localhost:"+port+"/api/v1/posts/"+updateID;

        HttpEntity<PostsUpdateRequestDto> requestEntity  =  new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectTitle);
        assertThat(all.get(0).getContext()).isEqualTo(expectContext);
    }
}
