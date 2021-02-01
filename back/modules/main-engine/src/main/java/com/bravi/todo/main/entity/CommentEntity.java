package com.bravi.todo.main.entity;

import com.bravi.todo.main.projection.CommentProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentEntity implements CommentProjection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false)
    private Long id;

    @Column(name = "TODO_ID", nullable = false)
    private Long todoId;

    @Column(name = "VALUE", nullable = false)
    private String value;

}
