package claude.mcp.example.service;

import claude.mcp.example.entity.Todo;
import claude.mcp.example.entity.User;
import claude.mcp.example.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    
    private final TodoRepository todoRepository;
    
    @Transactional(readOnly = true)
    public List<Todo> getAllTodosByUser(User user) {
        return todoRepository.findByUserOrderByCreatedAtDesc(user);
    }
    
    @Transactional(readOnly = true)
    public Optional<Todo> getTodoByIdAndUser(Long id, User user) {
        return todoRepository.findByIdAndUser(id, user);
    }
    
    public Todo createTodo(String title, String description, User user) {
        Todo todo = new Todo(title, description, user);
        return todoRepository.save(todo);
    }
    
    public Todo updateTodo(Long id, String title, String description, Boolean completed, User user) {
        Todo todo = todoRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new IllegalArgumentException("해당 투두를 찾을 수 없습니다."));
        
        todo.setTitle(title);
        todo.setDescription(description);
        todo.setCompleted(completed != null ? completed : false);
        
        return todoRepository.save(todo);
    }
    
    public void deleteTodo(Long id, User user) {
        Todo todo = todoRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new IllegalArgumentException("해당 투두를 찾을 수 없습니다."));
        
        todoRepository.delete(todo);
    }
    
    public Todo toggleComplete(Long id, User user) {
        Todo todo = todoRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new IllegalArgumentException("해당 투두를 찾을 수 없습니다."));
        
        todo.setCompleted(!todo.getCompleted());
        return todoRepository.save(todo);
    }
}
