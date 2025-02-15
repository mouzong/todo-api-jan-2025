package cm.adacorp.todoappapi.services;

import cm.adacorp.todoappapi.model.TodoModel;

import java.util.List;
import java.util.UUID;

public interface TodoService {
    List<TodoModel> getTodos();

    TodoModel create(TodoModel todoModel);

    TodoModel getTodoById(UUID id);

    TodoModel getTodoByTitle(String title);
}
