package be.octave.bootvuejs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    private static List<Todo> todos = new LinkedList<>(Arrays.asList(
            new Todo(1,"delectus aut autem", false),
            new Todo(2, "quis ut nam facilis et officia qui", true),
            new Todo(3, "fugiat veniam minus", true),
            new Todo(4, "et porro tempora", false),
            new Todo(5, "laboriosam mollitia et enim quasi adipisci quia provident illum", false)
            )
    );

    @GetMapping("/todos")
    public List<Todo> findTodos() {
        return todos;
    }

    @PostMapping("/todos")
    public int createTodo(@RequestBody Todo todo){
        logger.info("Creating todo :" + todo);
        int id = todos.size() + 1;
        todo.setId(id);
        todos.add(todo);
        return id;
    }

    @DeleteMapping("/todos/{id}")
    public boolean deleteTodo(@PathVariable("id") int id) {
       todos = todos.stream()
                .filter(todo -> todo.getId() != id)
                .collect(Collectors.toList());
        return true;
    }
}
