package com.example.simpleboard.post.controller;

import com.example.simpleboard.common.Api;
import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.model.PostRequest;
import com.example.simpleboard.post.model.PostViewRequest;
import com.example.simpleboard.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("")
    public PostEntity create(
            @RequestBody @Valid PostRequest postRequest
            ){
        return postService.create(postRequest);
    }

    @PostMapping("/view")
    public PostEntity view(
            @Valid @RequestBody PostViewRequest postViewRequest
            ) {

        return postService.view(postViewRequest );

    }

    @GetMapping("/all")
    public Api<List<PostEntity>> list(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
            ) {
        return postService.all(pageable);
    }

    @PostMapping("/delete")
    public void delete(
            @Valid @RequestBody PostViewRequest postViewRequest
    ) {
        postService.delete(postViewRequest);
    }
}
