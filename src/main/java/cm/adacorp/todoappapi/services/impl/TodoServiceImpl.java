package cm.adacorp.todoappapi.services.impl;

import cm.adacorp.todoappapi.dto.TodoDto;
import cm.adacorp.todoappapi.exceptions.TodoAlreadyExistsException;
import cm.adacorp.todoappapi.exceptions.TodoNotFoundException;
import cm.adacorp.todoappapi.mapper.TodoMapper;
import cm.adacorp.todoappapi.model.TodoModel;
import cm.adacorp.todoappapi.repositories.TodoRepository;
import cm.adacorp.todoappapi.services.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;


    @Override
    public List<TodoModel> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void create(TodoDto todoDto) {
        TodoModel todoModel = TodoMapper.mapToTodoModel(new TodoModel(), todoDto);

        Optional<TodoModel> existingTodoModel = todoRepository.findByTitle(
                todoDto.title());

        if (existingTodoModel.isPresent()){
            log.info("Tried to create an existing todo : "+todoDto.title());
            throw new TodoAlreadyExistsException("Todo with title: "+todoDto.title()+" already exist in DataBase, change the title...");
        }

        todoRepository.save(todoModel);
    }

    @Override
    public TodoModel getTodoById(UUID id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public TodoModel getTodoByTitle(String title) {
        return todoRepository.findByTitle(title).orElse(null);
    }

    @Override
    public String deleteTodoById(UUID todoId) {
        TodoModel foundTodo = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodoNotFoundException("Todo with ID : "+todoId+" not found..."));

        todoRepository.delete(foundTodo);

        return "Todos with ID : "+todoId+ " deleted successfully...";
    }

    @Override
    public String updateTodo(UUID todoId, TodoModel todoModel) {

        TodoModel foundTodo = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodoNotFoundException("Todo with ID : "+todoId+" not found..."));

        foundTodo.setTitle(todoModel.getTitle());
        foundTodo.setDescription(todoModel.getDescription());

        todoRepository.save(foundTodo);

        return "Todo with ID: "+todoId+" updated successfully..!";
    }

}
