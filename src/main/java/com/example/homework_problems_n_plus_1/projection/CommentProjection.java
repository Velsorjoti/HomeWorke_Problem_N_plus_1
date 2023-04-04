package com.example.homework_problems_n_plus_1.projection;

import com.example.homework_problems_n_plus_1.DTO.CommentDTO;

public interface CommentProjection {
    Long getId();
    String getBody();
    Long getPostId();

    default CommentDTO fromCommentProjectionToCommentDTO () {
        CommentDTO dto = new CommentDTO();
        dto.setId(getId());
        dto.setBody(getBody());
        return dto;
    }
}
//