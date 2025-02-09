package cm.adacorp.todoappapi.controllers;

import cm.adacorp.todoappapi.model.TodoModel;
import cm.adacorp.todoappapi.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public String getTodos() {
        return "OK ça marche";
    }

    @PostMapping("/create")
    public TodoModel createTodo() {
        return new TodoModel(
                UUID.randomUUID(),
                "Faire les courses",
                "Je veux faire les courses de la semaine");
    }
}
