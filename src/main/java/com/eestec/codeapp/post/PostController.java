package com.eestec.codeapp.post;

import com.eestec.codeapp.base.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public RestResponse findAll() {
        return new RestResponse(true).setData(postService.fetchAll());
    }

    @GetMapping
    public RestResponse findOne(@RequestParam(value = "id") Long id) {
        return new RestResponse(true).setData(postService.fetchOne(id));
    }

    @PostMapping
    public RestResponse save(@RequestBody @Valid PostDto postDto) {
        return new RestResponse(true).setData(postService.save(postDto));
    }

    @DeleteMapping
    public RestResponse delete(@RequestParam Long postId) {
        postService.delete(postId);
        return new RestResponse(true);
    }

    @GetMapping(value = "/user/{id}")
    public RestResponse findByUserId(@RequestParam Long id) {
        return new RestResponse(true).setData(postService.findAllPostsByUser(id));
    }

    @GetMapping(value = "/city/{id}")
    public RestResponse findByCityId(@RequestParam Long id) {
        return new RestResponse(true).setData(postService.findAllPostsByCity(id));
    }


}
