package com.zadatak.vicevi_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "joke", schema = "public")
public class Joke {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=1, max=499)
    private String content;
    private Long likes = 0L;
    private Long dislikes = 0L;
    private Long category_id;

    @ManyToOne(optional=false)
    @JoinColumn(name="category_id",referencedColumnName="id", insertable=false, updatable=false)
    @Autowired
    private Category category;


    @Autowired
    public Joke() {
    }

    @Autowired
    public Joke(Long id, String content, Long likes, Long dislikes, Long category_id) {
        this.id = id;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
        this.category_id = category_id;
    }

    @JsonIgnore
    public Category getCategory(){
        return category;
    }

    @JsonIgnore
    public void setCategory(Category category){
        this.category = category;
    }

    //getter za category id iz category child objekta
    public Long getCategoryId(){
        return category.getId();
    }

    //getter za category name isto iz child objekta
    public String getCategoryName(){
        return category.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, content='%s', likes='%s', dislikes='%s', category_id='%s']",
                id, content, likes, dislikes, category_id);
    }



}
