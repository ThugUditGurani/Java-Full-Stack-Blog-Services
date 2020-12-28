package com.professorgeeks.mainservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.professorgeeks.mainservice.common.DateModel;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter @Setter
public class Topic extends DateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    private String title;
    @NotNull
    @Column
    @Lob
    private String content;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "post_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Post post;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "topic")
    private List<Comment> comments = new ArrayList<>();
}
