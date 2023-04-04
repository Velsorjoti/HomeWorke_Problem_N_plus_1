package com.example.homework_problems_n_plus_1.controller;

import com.example.homework_problems_n_plus_1.DTO.ActiveUserDTO;
import com.example.homework_problems_n_plus_1.DTO.PostDTO;
import com.example.homework_problems_n_plus_1.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public ResponseEntity<List<ActiveUserDTO>> findTopTenUsersByNumberOfComments() {
        return ResponseEntity.ok(postService.getTopTenUsersNumberOfComments());
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDTO>> getAllPosts(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        if (page == null && size == null) {
            return ResponseEntity.ok(postService.getAllPosts());
        }
        return ResponseEntity.ok(postService.getAllPostPagination(page, size));
    }
    @GetMapping ("/comments")
    public ResponseEntity<List<PostDTO>> getAllPostWhereCommentBodyLike(@RequestParam String body) {
        return ResponseEntity.ok(postService.getPostsWithBodyLike(body));
    }
}
//