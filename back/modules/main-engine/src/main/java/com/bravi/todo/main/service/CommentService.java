package com.bravi.todo.main.service;

import com.bravi.todo.main.dto.CommentDTO;
import com.bravi.todo.main.mapper.CommentMapper;
import com.bravi.todo.main.projection.CommentProjection;
import com.bravi.todo.main.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentProjection insert(CommentDTO dto) {
        return commentRepository.save(commentMapper.toEntity(dto));
    }
}
