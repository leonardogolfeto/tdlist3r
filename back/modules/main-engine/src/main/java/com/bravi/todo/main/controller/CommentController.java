package com.bravi.todo.main.controller;

import com.bravi.todo.main.dto.CommentDTO;
import com.bravi.todo.main.projection.CommentProjection;
import com.bravi.todo.main.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentProjection insertNewComment(@RequestBody CommentDTO dto){
        return commentService.insert(dto);
    }
}
