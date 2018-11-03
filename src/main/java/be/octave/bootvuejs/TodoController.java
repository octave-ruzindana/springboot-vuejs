package be.octave.bootvuejs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    final TodoRepository todoRepository;

    @PostConstruct
    protected void init(){

        todoRepository.save(new Todo("delectus aut autem", false));
        todoRepository.save(new Todo("quis ut nam facilis et officia qui", true));
        todoRepository.save(new Todo("fugiat veniam minus", true));
        todoRepository.save(new Todo("et porro tempora", false));
        todoRepository.save(new Todo("laboriosam mollitia et enim quasi adipisci quia provident illum", false));

}

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public Iterable<Todo> findTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/todos")
    public int createTodo(@RequestBody Todo todo){
        logger.info("Creating todo : {}",  todo);
        return todoRepository.save(todo).getId();
    }

    @DeleteMapping("/todos/{id}")
    public boolean deleteTodo(@PathVariable("id") int id) {
        logger.info("Deleting todo with id {}", id);
        todoRepository.deleteById(id);
        return true;
    }
}
