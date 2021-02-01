package com.bravi.todo.main.projection;

import java.time.LocalDate;
import java.util.List;

public interface TodoProjection {

    Long getId();
    String getBoardName();
    String getDescription();
    LocalDate getCompletionDate();
    Boolean getCompleted();
    Double getHoursSpent();
    List<CommentProjection> getComments();
}
