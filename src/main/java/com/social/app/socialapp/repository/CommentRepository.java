package com.social.app.socialapp.repository;

import com.social.app.socialapp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
