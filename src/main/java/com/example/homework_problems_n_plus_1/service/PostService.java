package com.example.homework_problems_n_plus_1.service;

import com.example.homework_problems_n_plus_1.DTO.ActiveUserDTO;
import com.example.homework_problems_n_plus_1.DTO.PostDTO;
import com.example.homework_problems_n_plus_1.model.Post;
import com.example.homework_problems_n_plus_1.projection.CommentProjection;
import com.example.homework_problems_n_plus_1.projection.PostProjection;
import com.example.homework_problems_n_plus_1.projection.UserProjection;
import com.example.homework_problems_n_plus_1.repository.CommentRepository;
import com.example.homework_problems_n_plus_1.repository.PostRepository;
import com.example.homework_problems_n_plus_1.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    UserRepository userRepository;
    PostRepository postRepository;
    CommentRepository commentRepository;

    public PostService(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<ActiveUserDTO> getTopTenUsersNumberOfComments() {
        List<UserProjection> users = postRepository.findTopTenUsersByNumberOfComments();
        return users.stream().map(UserProjection::fromUserProjectionToUserDTO)
                .collect(Collectors.toList());
    }
    public List<PostDTO> getAllPosts(){
        return postRepository.findAllBy().stream()
                .map(PostDTO::fromPostToPostDTO)
                .collect(Collectors.toList());
    }
    public List<PostDTO> getAllPostPagination(Integer pageNumber, Integer pageSize) {
        List<PostProjection> projBy = postRepository.findAllBy(PageRequest.of(pageNumber - 1, pageSize));
        List<CommentProjection> byPostIdIn = commentRepository.findByPostIdIn(projBy.stream()
                .map(PostProjection::getId)
                .collect(Collectors.toList()));
        return projBy.stream()
                .map(PostProjection::fromPostProjectionToPostDTO)
                .peek(postDTO -> postDTO.setComments((byPostIdIn.stream()
                        .filter(comment -> comment.getPostId().equals(postDTO.getId())))
                        .map(CommentProjection::fromCommentProjectionToCommentDTO).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
    public List<PostDTO> getPostsWithBodyLike(String body) {
        List<Post> posts = postRepository.findByCommentsBodyContaining(body);
        return posts.stream()
                .map(PostDTO::fromPostToPostDTO)
                .collect(Collectors.toList());
    }
}
//