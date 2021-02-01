package com.bravi.todo.main.controller;

import com.bravi.todo.main.dto.TodoDTO;
import com.bravi.todo.main.projection.TodoProjection;
import com.bravi.todo.main.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public TodoProjection insertTodo(@RequestBody TodoDTO dto) {
        return todoService.insert(dto);
    }

    @PostMapping("/{id}")
    public TodoProjection insertTodo(@RequestBody TodoDTO dto, @PathVariable String id) {
        return todoService.alter(dto, Long.parseLong(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

    @GetMapping("/{board}")
    public List<TodoProjection> findTodoByBoardName(@PathVariable String board){
        return todoService.findByBoardName(board);
    }

}
