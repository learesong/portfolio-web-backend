package com.learesong.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    BlogPostRepository blogPostRepository;

    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost addBlogPost(@RequestBody BlogPost post) {
                blogPostRepository.save(post);
                return post;
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public BlogPost findBlogPostById(Long id){
        return blogPostRepository.findById(id).get();

    }

    public ResponseEntity<BlogPost> editBlogPost(BlogPost blogPost) {
            BlogPost updateBlogPost = blogPostRepository.findById(blogPost.getId()).get();
            updateBlogPost.setTitle(blogPost.getTitle());
            updateBlogPost.setSubTitle(blogPost.getSubTitle());
            updateBlogPost.setLink(blogPost.getLink());
            updateBlogPost.setContent(blogPost.getContent());
            updateBlogPost.setCategory(blogPost.getCategory());
            blogPostRepository.save(updateBlogPost);
        return ResponseEntity.ok(blogPost);
    }

    public ResponseEntity<BlogPost> deleteBlogPost(Long id) {
        BlogPost deletedPost = findBlogPostById(id);
                blogPostRepository.deleteById(id);
        return new ResponseEntity<BlogPost>(deletedPost, HttpStatus.OK);
    }
}
