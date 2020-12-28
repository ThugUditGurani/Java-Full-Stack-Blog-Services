package com.professorgeeks.mainservice.model;

import com.professorgeeks.mainservice.common.DateModel;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "posts")
@Getter @Setter
public class Post  extends DateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    private String title;
    @NotNull
    @Lob
    @Column
    private String content;
    @Column
    @NotNull
    private String username;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "post")
    private List<Topic> topicList = new ArrayList<>();

}
