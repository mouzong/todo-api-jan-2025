package cm.adacorp.todoappapi.services.impl;

import cm.adacorp.todoappapi.model.TodoModel;
import cm.adacorp.todoappapi.repositories.TodoRepository;
import cm.adacorp.todoappapi.repositories.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Disabled
@ExtendWith(MockitoExtension.class)
class TodoServiceImplTest {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TodoServiceImpl todoService;

    @Test
    void testGetTodos() {
    }

    @Test
    void testCreateTodo() {
    }

    @Test
    void testGetTodoById() {
        // Arrange
        TodoModel todo = new TodoModel(
                UUID.randomUUID(),
                "Service Tester",
                "Testing the service for getById"
        );
        when(todoRepository.findById(todo.getTodoId())).thenReturn(Optional.of(todo));

        // Act
        TodoModel foundTodo = todoService.getTodoById(todo.getTodoId());

        // Assert
        assertNotNull(foundTodo);
        assertEquals("Service Tester", foundTodo.getTitle());
        verify(todoRepository, times(1)).findById(todo.getTodoId());
    }


    @Test
    void testGetTodoByTitle() {
    }

    @Test
    void testDeleteTodoById() {
    }

    @Test
    void testUpdateTodo() {
    }
}