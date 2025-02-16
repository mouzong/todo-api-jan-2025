package cm.adacorp.todoappapi.controllers;

import cm.adacorp.todoappapi.dto.ResponseDto;
import cm.adacorp.todoappapi.dto.TodoDto;
import cm.adacorp.todoappapi.model.TodoModel;
import cm.adacorp.todoappapi.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static cm.adacorp.todoappapi.constants.TodoConstants.MESSAGE_201;
import static cm.adacorp.todoappapi.constants.TodoConstants.STATUS_201;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoModel> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/{id}")
    public TodoModel getTodoById(@PathVariable UUID id) {
        return todoService.getTodoById(id);
    }

    @GetMapping("/get/{title}")
    public TodoModel getTodoByTitle(@PathVariable String title) {
        return todoService.getTodoByTitle(title);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createTodo(@RequestBody TodoDto todoDto) {
        todoService.create(todoDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseDto.builder()
                        .statusCode(STATUS_201)
                        .statusMessage(MESSAGE_201)
                        .build());
    }

    @DeleteMapping("/{id}")
    public String deleteTodoById(@PathVariable("id") UUID todoId){
        return todoService.deleteTodoById(todoId);
    }

    @PutMapping("/{id}")
    public String editTodo(@PathVariable("id") UUID todoId, @RequestBody TodoModel todoModel){
        return todoService.updateTodo(todoId, todoModel);

    }
}
