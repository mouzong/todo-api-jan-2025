package cm.adacorp.todoappapi.repositories;

import cm.adacorp.todoappapi.model.TodoModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        final var todoModel = new TodoModel(
                null,
                "Test first",
                "Creating Todo to test JUnit in our app"
        );

        String title = todoModel.getTitle();

        // Act
        final var savedTodoModel = todoRepository.save(todoModel);

        // Assert
        assertThat(savedTodoModel.getTitle()).isEqualTo(title);
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