package com.professorgeeks.mainservice.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table
@Getter @Setter
public class Home {
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
    private Instant createdOn;
    @Column
    private Instant updatedOn;
    @Column
    @NotNull
    private String username;

//    @OneToMany
//    @JoinColumn()
//    private List<Topic> topicList;
}
