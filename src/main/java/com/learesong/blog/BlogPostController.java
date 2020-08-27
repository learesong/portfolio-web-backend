package com.learesong.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blogs")
    @ResponseBody
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<BlogPost> findBlogPostByyId(@PathVariable("id") Long id){
        return new ResponseEntity<BlogPost>(blogPostService.findBlogPostById(id), HttpStatus.OK);
    }

    @PostMapping("/blogs")
    @ResponseBody
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost){
        return blogPostService.addBlogPost(blogPost);
    }

    @PutMapping("/blogs")
    public ResponseEntity<BlogPost> editBlogPost(@RequestBody BlogPost blogPost){
        return blogPostService.editBlogPost(blogPost);
    }

    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<BlogPost> deleteBlogPost(@PathVariable("id") Long id){
        return blogPostService.deleteBlogPost(id);
    }

}
