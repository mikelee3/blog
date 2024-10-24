package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;

import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Post extends BaseEntity {

    private String title;
    private String content;

    @NaturalId
    @EqualsAndHashCode.Include
    @Column(unique = true)
    final private UUID uuid = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
}