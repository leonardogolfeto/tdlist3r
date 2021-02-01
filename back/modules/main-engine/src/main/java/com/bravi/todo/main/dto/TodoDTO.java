package com.bravi.todo.main.dto;

import com.bravi.todo.main.projection.CommentProjection;
import com.bravi.todo.main.projection.TodoProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO implements TodoProjection {

    private Long id;
    private String boardName;
    private String description;
    private LocalDate completionDate;
    private Boolean completed;
    private Double hoursSpent;
    private List<CommentProjection> comments;

}
