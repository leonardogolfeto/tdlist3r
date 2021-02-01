package com.bravi.todo.main.entity;

import com.bravi.todo.main.projection.CommentProjection;
import com.bravi.todo.main.projection.TodoProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoEntity implements TodoProjection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", updatable = false)
    private Long id;

    @Column(name="BOARD_NAME", nullable = false)
    private String boardName;

    @Setter
    @Column(name="DESCRIPTION")
    private String description;

    @Setter
    @Column(name="COMPLETION_DATE")
    private LocalDate completionDate;

    @Setter
    @Column(name="COMPLETION")
    private Boolean completed = false;

    @Setter
    @Column(name = "HOURS_SPENT")
    private Double hoursSpent;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TODO_ID")
    private List<CommentEntity> comments;

    public List<CommentProjection> getComments() {
        return new ArrayList<>(comments);
    }
}
