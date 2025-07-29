package claude.mcp.example.service;

import claude.mcp.example.dto.CreateTodoRequest;
import claude.mcp.example.dto.TodoResponse;
import claude.mcp.example.dto.UpdateTodoRequest;
import claude.mcp.example.entity.Todo;
import claude.mcp.example.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    
    private final TodoRepository todoRepository;
    
    // 전체 투두 조회
    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    
    // 단건 투두 조회
    public TodoResponse getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID " + id + "에 해당하는 투두를 찾을 수 없습니다"));
        return convertToResponse(todo);
    }
    
    // 투두 생성
    @Transactional
    public TodoResponse createTodo(CreateTodoRequest request) {
        Todo todo = Todo.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .isDone(false)
                .build();
        
        Todo savedTodo = todoRepository.save(todo);
        return convertToResponse(savedTodo);
    }
    
    // 투두 수정
    @Transactional
    public TodoResponse updateTodo(Long id, UpdateTodoRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID " + id + "에 해당하는 투두를 찾을 수 없습니다"));
        
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        todo.setIsDone(request.getIsDone());
        
        Todo updatedTodo = todoRepository.save(todo);
        return convertToResponse(updatedTodo);
    }
    
    // 투두 삭제
    @Transactional
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID " + id + "에 해당하는 투두를 찾을 수 없습니다"));
        todoRepository.delete(todo);
    }
    
    // 완료 상태별 조회
    public List<TodoResponse> getTodosByDoneStatus(Boolean isDone) {
        return todoRepository.findByIsDone(isDone).stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    
    // Entity를 DTO로 변환
    private TodoResponse convertToResponse(Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .isDone(todo.getIsDone())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }
}
