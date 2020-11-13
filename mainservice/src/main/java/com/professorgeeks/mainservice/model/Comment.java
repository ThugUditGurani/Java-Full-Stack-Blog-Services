package com.professorgeeks.mainservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.professorgeeks.mainservice.common.DateModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter @Setter
public class Comment extends DateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String text;
    @Column
    private String username;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "topic_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Topic topic;


}
