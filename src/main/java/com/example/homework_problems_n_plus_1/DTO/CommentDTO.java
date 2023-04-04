package com.example.homework_problems_n_plus_1.DTO;

import com.example.homework_problems_n_plus_1.model.Comment;

public class CommentDTO {
    private Long id;
    private String body;

    public CommentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static CommentDTO fromCommentToCommentDTO(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        return dto;
    }
}
//