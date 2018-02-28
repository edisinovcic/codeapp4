package com.eestec.codeapp.post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public List<Post> fetchAll();

    public Optional<Post> fetchOne(Long id);

    public Optional<Post> save(PostDto postDto);

    public void delete(Long id);

    public void deleteAll();

    public List<Post> findAllPostsByUser(Long userId);

    public List<Post> findAllPostsByCity(Long cityId);

}
