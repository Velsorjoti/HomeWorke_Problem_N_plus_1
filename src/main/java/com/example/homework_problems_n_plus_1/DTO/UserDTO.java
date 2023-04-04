package com.example.homework_problems_n_plus_1.DTO;

import com.example.homework_problems_n_plus_1.model.Post;
import com.example.homework_problems_n_plus_1.model.User;

public class UserDTO {
    private Long id;
    private String userName;
    private Long postCount;
    private Long commentCount;
    private Post post;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPostCount() {
        return postCount;
    }

    public void setPostCount(Long postCount) {
        this.postCount = postCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public static UserDTO fromUserToUserDTO (User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUserName(user.getUserName());
        return dto;
    }
}
//