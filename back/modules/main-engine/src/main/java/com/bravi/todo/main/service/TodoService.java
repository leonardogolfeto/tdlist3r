package com.bravi.todo.main.service;

import com.bravi.todo.main.dto.TodoDTO;
import com.bravi.todo.main.projection.TodoProjection;
import com.bravi.todo.main.mapper.TodoMapper;
import com.bravi.todo.main.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public List<TodoProjection> findByBoardName(String boardName) {
        return todoRepository.findAllByBoardName(boardName);
    }

    public TodoProjection insert(TodoProjection projection) {
        return todoRepository.save(todoMapper.toEntity(projection));
    }

    public TodoProjection alter(TodoDTO dto, Long id) {

        todoRepository.findById(id).ifPresent(entity -> {
            entity.setCompleted(dto.getCompleted());
            entity.setDescription(dto.getDescription());
            entity.setHoursSpent(dto.getHoursSpent());
            entity.setCompletionDate(dto.getCompletionDate());
            todoRepository.save(entity);
        });

        return todoRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
