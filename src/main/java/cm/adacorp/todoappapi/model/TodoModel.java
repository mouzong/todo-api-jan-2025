package cm.adacorp.todoappapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class TodoModel {
    @Id
    @GeneratedValue
    private UUID toId;

    private String title;

    private String description;

}
