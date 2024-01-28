package com.social.app.socialapp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String caption;
    private String image;
    private String video;
    @ManyToOne
    private User user;
    private LocalDateTime createdAt;
    @OneToMany
    private List<Comment> comments=new ArrayList<>();
    @OneToMany
    private List<User> liked=new ArrayList<>();

    public Post() {
    }
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Post(Integer id, String caption, String image, String video, User user, LocalDateTime createdAt, List<Comment> comments, List<User> liked) {
        this.id = id;
        this.caption = caption;
        this.image = image;
        this.video = video;
        this.user = user;
        this.createdAt = createdAt;
        this.comments = comments;
        this.liked = liked;
    }

    public List<User> getLiked() {
        return liked;
    }

    public void setLiked(List<User> liked) {
        this.liked = liked;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getImage() {
        return image;
    }

    public String getVideo() {
        return video;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
