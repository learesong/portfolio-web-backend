package com.learesong.blog;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="blog")
@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="blog_id")
    private Long id;

    @NotNull
    @NonNull
    @Column(name="blog_title")
    private String title;

    @NotNull
    @NonNull
    @Column(name="blog_sub_title")
    private String subTitle;

    @NotNull
    @NonNull
    @Column(name="blog_link")
    private String link;

    @NotNull
    @NonNull
    @Column(name="blog_category")
    private String category;

    @NotNull
    @NonNull
    @Column(name="blog_content", length=10485760)
    private String content;

    @Column(name="image")
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
