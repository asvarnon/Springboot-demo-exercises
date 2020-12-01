package com.codeup.demo.repos;

import com.codeup.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    Post findByDescription(String desc);
    List<Post> findAllByTitleIsLike(String term);

}
