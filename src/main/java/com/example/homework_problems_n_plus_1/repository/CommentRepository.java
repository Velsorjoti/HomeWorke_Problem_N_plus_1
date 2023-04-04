package com.example.homework_problems_n_plus_1.repository;

import com.example.homework_problems_n_plus_1.model.Comment;
import com.example.homework_problems_n_plus_1.projection.CommentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT a.id, a.body, a.post_id AS postId FROM comment AS a WHERE a.post_id IN (?1) "
            , nativeQuery = true)

    List<CommentProjection> findByPostIdIn(List<Long> postIds);
}
//