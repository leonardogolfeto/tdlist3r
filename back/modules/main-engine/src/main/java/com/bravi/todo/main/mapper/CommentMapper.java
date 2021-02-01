package com.bravi.todo.main.mapper;

import com.bravi.todo.main.dto.CommentDTO;
import com.bravi.todo.main.entity.CommentEntity;
import com.bravi.todo.main.projection.CommentProjection;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentEntity toEntity(CommentProjection dto) {
        return new CommentEntity(dto.getId(), dto.getTodoId(), dto.getValue());
    }

    public CommentDTO toDTO(CommentProjection entity) {
        return new CommentDTO(entity.getId(), entity.getTodoId(), entity.getValue());
    }
}
