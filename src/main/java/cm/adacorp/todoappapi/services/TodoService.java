package cm.adacorp.todoappapi.services;

import cm.adacorp.todoappapi.dto.TodoDto;
import cm.adacorp.todoappapi.model.TodoModel;

import java.util.List;
import java.util.UUID;

public interface TodoService {
    List<TodoModel> getTodos();

    void create(TodoDto todoDto);

    TodoModel getTodoById(UUID id);


    TodoModel getTodoByTitle(String title);

    String deleteTodoById(UUID todoId);

    String updateTodo(UUID todoId, TodoModel todoModel);
}
