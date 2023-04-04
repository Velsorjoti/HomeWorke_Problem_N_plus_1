package com.example.homework_problems_n_plus_1.DTO;

import com.example.homework_problems_n_plus_1.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDTO {
    private Long id;
    private String title;
    private String body;
    private List<CommentDTO> comments;
    private UserDTO user;

    public PostDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public static PostDTO fromPostToPostDTO (Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        List<CommentDTO> comments = post.getComments().stream()
                .map(CommentDTO::fromCommentToCommentDTO)
                .collect(Collectors.toList());
        dto.setComments(comments);
        dto.setUser(UserDTO.fromUserToUserDTO(post.getUser()));
        return dto;
    }
}
//