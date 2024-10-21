package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Post extends BaseEntity {

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
}