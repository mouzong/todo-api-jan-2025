package cm.adacorp.todoappapi.repositories;

import cm.adacorp.todoappapi.model.TodoModel;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoRepositoryTest {
    /**
     * BDD : Behaviour Driven Development
     */

    @Autowired
    private TodoRepository todoRepository;

    @Test
    @DisplayName("Test Save Todo")
    void testSaveTodoInDataBase(){
        // Arrange
        TodoModel todoModel = new TodoModel(
                null,
                "Test first",
                "Creating Todod to test JUnit in our app"
        );
        String title = todoModel.getTitle();

        // Act
        TodoModel savedTodoModel = todoRepository.save(todoModel);

        savedTodoModel.setTitle("Fake title");

        System.out.println("\n\t Saved: "+savedTodoModel.getTitle());
        System.out.println("\n\t Input: "+todoModel.getTitle());


        // Assert
//        assertEquals(savedTodoModel.getTitle(), todoModel.getTitle());

        assertThat(savedTodoModel.getTitle().equals(todoModel.getTitle())).isFalse();
    }



    @Test
    void testFindTodoById(){
        // Arrange - Given


        // Act - When


        // Assert - Then

    }


    @Test
    @Disabled
    @DisplayName("Test : Get Todo by a given title")
    void findByTitle() {
    }
}