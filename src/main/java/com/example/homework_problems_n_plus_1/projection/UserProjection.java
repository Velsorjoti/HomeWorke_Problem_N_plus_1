package com.example.homework_problems_n_plus_1.projection;

import com.example.homework_problems_n_plus_1.DTO.ActiveUserDTO;

public interface UserProjection {
    Long getUserId();
    String getUsername();
    Long getAllPostCount();
    Long getAllCommentsCount();
    Long getLastPostId();

    default ActiveUserDTO fromUserProjectionToUserDTO() {
        ActiveUserDTO dto = new ActiveUserDTO();
        dto.setId(getUserId());
        dto.setUsername(getUsername());
        dto.setPostCount(getAllPostCount());
        dto.setCommentCount(getAllCommentsCount());
        dto.setLastPostId(getLastPostId());
        return dto;
    }
}
