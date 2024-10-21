package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Comment extends BaseEntity {

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
}