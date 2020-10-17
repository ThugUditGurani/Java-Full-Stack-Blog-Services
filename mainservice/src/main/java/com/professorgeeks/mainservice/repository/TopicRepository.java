package com.professorgeeks.mainservice.repository;

import com.professorgeeks.mainservice.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {
    Page<Topic> findByPostId(Long postId, Pageable pageable);
    Optional<Topic> findByIdAndPostId(Long id,Long postId);
}
