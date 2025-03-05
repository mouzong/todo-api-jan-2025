package cm.adacorp.todoappapi.repositories;

import cm.adacorp.todoappapi.model.TodoModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@DataJpaTest
class TodoRepositoryTest {
    /**
     * BDD : Behaviour Driven Development
     */

    @Autowired
    private TodoRepository todoRepository;

    @Test
    @DisplayName("Test Save Todo in Database")
    void testSaveTodoInDataBase() {
        // Arrange
        final var todoModel = new TodoModel(
                "Test first",
                "Creating Todo to test JUnit in our app"
        );

        String title = todoModel.getTitle();

        // Act
        final var savedTodoModel = todoRepository.save(todoModel);

        // Assert
        assertThat(savedTodoModel.getTitle()).isEqualTo(title);
        assertThat(savedTodoModel.getTodoId()).isNotNull();
    }


    @Test
    @DisplayName("Test: Find Todo By ID")
    void testFindTodoById() {
        // Arrange - Given
        TodoModel todo = new TodoModel(
                "Test first",
                "Creating Todo to test JUnit in our app"
        );
        todo = todoRepository.save(todo);

        // Act - When
        Optional<TodoModel> foundTodo = todoRepository.findById(todo.getTodoId());


        // Assert - Then
        assertTrue(foundTodo.isPresent());
        assertEquals("Test first", foundTodo.get().getTitle());

    }


    @Test
    @DisplayName("Test : Get Todo by a given title")
    void testFindByTitle() {
        // Arrange - Given
        TodoModel todo = new TodoModel(
                "Test first",
                "Creating Todo to test JUnit in our app"
        );
        todo = todoRepository.save(todo);

        // Act - When
        Optional<TodoModel> foundTodo = todoRepository.findByTitle(todo.getTitle());


        // Assert - Then
        assertTrue(foundTodo.isPresent());
        assertEquals("Test first", foundTodo.get().getTitle());
    }

    @Test
    @DisplayName("Test: Find all Todos in DB")
    void testFindAllTodos(){
        // Arrange
        List<TodoModel> modelList = List.of(
                new TodoModel("Test repository","Get all repos methods working"),
                new TodoModel("Build local Dev POC","Finish the setup of local environment"),
                new TodoModel("Deploy Aircrack-NG","Get binaries for aircrack-ng"),
                new TodoModel("Clean-up environment","Delete unused docs to clean-up memory")
        );

        todoRepository.saveAll(modelList);

        // Act
        List<TodoModel> foundTodos = todoRepository.findAll();

        // Assert
        assertEquals(4, foundTodos.size());
    }
}