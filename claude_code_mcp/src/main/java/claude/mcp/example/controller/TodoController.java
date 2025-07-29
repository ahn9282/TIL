package claude.mcp.example.controller;

import claude.mcp.example.dto.ApiResponse;
import claude.mcp.example.dto.CreateTodoRequest;
import claude.mcp.example.dto.TodoResponse;
import claude.mcp.example.dto.UpdateTodoRequest;
import claude.mcp.example.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    
    private final TodoService todoService;
    
    // 전체 투두 조회
    @GetMapping
    public ResponseEntity<ApiResponse<List<TodoResponse>>> getAllTodos() {
        List<TodoResponse> todos = todoService.getAllTodos();
        return ResponseEntity.ok(
                ApiResponse.success("투두 목록 조회 성공", todos)
        );
    }
    
    // 단건 투두 조회
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TodoResponse>> getTodoById(@PathVariable Long id) {
        try {
            TodoResponse todo = todoService.getTodoById(id);
            return ResponseEntity.ok(
                    ApiResponse.success("투두 조회 성공", todo)
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }
    
    // 투두 생성
    @PostMapping
    public ResponseEntity<ApiResponse<TodoResponse>> createTodo(@Valid @RequestBody CreateTodoRequest request) {
        TodoResponse createdTodo = todoService.createTodo(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("투두 생성 성공", createdTodo));
    }
    
    // 투두 수정
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TodoResponse>> updateTodo(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTodoRequest request) {
        try {
            TodoResponse updatedTodo = todoService.updateTodo(id, request);
            return ResponseEntity.ok(
                    ApiResponse.success("투두 수정 성공", updatedTodo)
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }
    
    // 투두 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTodo(@PathVariable Long id) {
        try {
            todoService.deleteTodo(id);
            return ResponseEntity.ok(
                    ApiResponse.<Void>success("투두 삭제 성공")
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }
    
    // 완료 상태별 조회
    @GetMapping("/status")
    public ResponseEntity<ApiResponse<List<TodoResponse>>> getTodosByStatus(@RequestParam Boolean isDone) {
        List<TodoResponse> todos = todoService.getTodosByDoneStatus(isDone);
        return ResponseEntity.ok(
                ApiResponse.success("상태별 투두 조회 성공", todos)
        );
    }
}
