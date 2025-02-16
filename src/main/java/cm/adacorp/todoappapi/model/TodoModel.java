package cm.adacorp.todoappapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "todos")
public class TodoModel {
    @Id
    @GeneratedValue
    private UUID toId;

    private String title;

    private String description;
}
