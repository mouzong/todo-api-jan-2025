package cm.adacorp.todoappapi.services.impl;

import cm.adacorp.todoappapi.repositories.TodoRepository;
import cm.adacorp.todoappapi.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    // IoC (Inversion of Control)
    // Dependency Injection (DI)
}
