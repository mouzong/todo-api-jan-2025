package cm.adacorp.todoappapi.mapper;

import cm.adacorp.todoappapi.dto.TodoDto;
import cm.adacorp.todoappapi.model.TodoModel;

public class TodoMapper {

    public static TodoModel mapToTodoModel(TodoModel todoModel, TodoDto todoDto) {
        todoModel.setTitle(todoDto.title());
        todoModel.setDescription(todoDto.description());
        return todoModel;

    }

    public static TodoDto mapToTodoDto(TodoModel todoModel) {
        return new TodoDto(todoModel.getTitle(), todoModel.getDescription());
    }
}
