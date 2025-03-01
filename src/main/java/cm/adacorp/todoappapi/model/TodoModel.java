package cm.adacorp.todoappapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "todos")
public class TodoModel {
    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private UUID todoId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    public TodoModel(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
