package com.eestec.codeapp.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> fetchAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> fetchOne(Long id) {
        return Optional.ofNullable(postRepository.findOne(id));
    }

    @Override
    public Optional<Post> save(PostDto postDto) {
        Optional<Post> optionalPost = Optional.ofNullable(postRepository.findByDescription(postDto.description));
        Post post = optionalPost.orElse(new Post(postDto));
        postRepository.save(post);
        return Optional.ofNullable(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        postRepository.deleteAll();
    }

    @Override
    public List<Post> findAllPostsByUser(Long userId) {
        return postRepository.findAllByUserId(userId);
    }

    @Override
    public List<Post> findAllPostsByCity(Long cityId) {
        return postRepository.findAllByCityId(cityId);
    }
}
