package com.example.homework_problems_n_plus_1.projection;

import com.example.homework_problems_n_plus_1.DTO.PostDTO;

public interface PostProjection {
    Long getId();
    String getTitle();
    String getBody();

    default PostDTO fromPostProjectionToPostDTO () {
        PostDTO dto = new PostDTO();
        dto.setId(getId());
        dto.setTitle(getTitle());
        dto.setBody(getBody());
        return dto;
    }
}
