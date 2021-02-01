package com.bravi.todo.main.dto;

import com.bravi.todo.main.projection.CommentProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements CommentProjection {

    private Long id;
    private Long todoId;
    private String value;

}
