package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tag;
    @ManyToMany(mappedBy = "tags", cascade=CascadeType.ALL)
    private Set<BlogPost> blogPosts;

    public Tag(){

    }

    public Tag(String tag){
        this.tag = tag;
    }

    public Tag(String tag, Set<BlogPost> blogPosts){
        this.tag = tag;
        this.blogPosts = blogPosts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Set<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(Set<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }
}
