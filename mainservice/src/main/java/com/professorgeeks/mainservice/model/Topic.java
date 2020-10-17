package com.professorgeeks.mainservice.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Topic {

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

//    @ManyToOne
//    @JoinColumn
//    private Home home;
}
