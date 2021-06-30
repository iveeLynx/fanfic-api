package com.yaskovskyi.fanficcourse.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String fanfic_date;
    @Column
    private String fanfic_description;
    @Column
    private String fanfic_fandom;
    @Column
    private String fanfic_name;
    @Column
    private String fanfic_tags;

//    private int rating;
//    private int likes;
//    private int dislikes;
}
