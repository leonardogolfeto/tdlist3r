package com.bravi.todo.main.repository;

import com.bravi.todo.main.projection.TodoProjection;
import com.bravi.todo.main.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoProjection> findAllByBoardName(String boardName);


}
