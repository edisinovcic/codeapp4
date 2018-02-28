package com.eestec.codeapp.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByDescription(String description);

    List<Post> findAllByUserId(Long id);

    List<Post> findAllByCityId(Long id);
}
