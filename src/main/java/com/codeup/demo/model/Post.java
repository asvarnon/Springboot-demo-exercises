package com.codeup.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn (name = "owner_id")
    @JsonManagedReference
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @JsonBackReference
    private List<PostImage> images;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_categories",
            joinColumns = {@JoinColumn(name= "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<PostCategory> categories;

    public Post(){};

    //CREATE note: has all info but id
    public Post(String title, String body, User owner, List<PostImage> images){
        this.title = title;
        this.body = body;
        this.owner = owner;
        this.images = images;
    }

    //READ
    public Post(long id, String title, String body, User owner, List<PostImage> images){
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public List<PostCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PostCategory> categories) {
        this.categories = categories;
    }
}
