package com.bravi.todo.main.mapper;

import com.bravi.todo.main.dto.CommentDTO;
import com.bravi.todo.main.dto.TodoDTO;
import com.bravi.todo.main.entity.CommentEntity;
import com.bravi.todo.main.projection.CommentProjection;
import com.bravi.todo.main.projection.TodoProjection;
import com.bravi.todo.main.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TodoMapper {

    private final CommentMapper commentMapper;

    public TodoEntity toEntity(TodoProjection projection){

        List<CommentEntity> comments = new ArrayList<>();

        if(projection.getComments() != null) {
            projection
                    .getComments()
                    .forEach(commentProjection -> comments.add(commentMapper.toEntity(commentProjection)));
        }

        return new TodoEntity(projection.getId(),
                projection.getBoardName(),
                projection.getDescription(),
                projection.getCompletionDate(),
                projection.getCompleted(),
                projection.getHoursSpent(),
                comments);
    }

    TodoDTO todoDTO(TodoEntity entity) {
        List<CommentProjection> comments = new ArrayList<>();

        if(entity.getComments() != null) {
            entity
                    .getComments()
                    .forEach(commentProjection -> comments.add(commentMapper.toDTO(commentProjection)));
        }

        return new TodoDTO(entity.getId(),
                entity.getBoardName(),
                entity.getDescription(),
                entity.getCompletionDate(),
                entity.getCompleted(),
                entity.getHoursSpent(),
                comments);
    }

}
