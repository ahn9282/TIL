package claude.mcp.example.controller;

import claude.mcp.example.dto.CreateTodoRequest;
import claude.mcp.example.dto.TodoResponse;
import claude.mcp.example.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoWebController {
    
    private final TodoService todoService;
    
    // 투두 목록 페이지
    @GetMapping
    public String list(Model model) {
        List<TodoResponse> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todos/list";
    }
    
    // 투두 생성 페이지
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("createTodoRequest", new CreateTodoRequest());
        return "todos/create";
    }
    
    // 투두 생성 처리
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute CreateTodoRequest createTodoRequest,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        
        if (bindingResult.hasErrors()) {
            return "todos/create";
        }
        
        try {
            todoService.createTodo(createTodoRequest);
            redirectAttributes.addFlashAttribute("message", "투두가 성공적으로 생성되었습니다.");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "투두 생성 중 오류가 발생했습니다.");
            redirectAttributes.addFlashAttribute("messageType", "error");
        }
        
        return "redirect:/todos";
    }
    
    // 투두 완료 상태 토글
    @PostMapping("/{id}/toggle")
    public String toggleComplete(@PathVariable Long id, 
                                RedirectAttributes redirectAttributes) {
        try {
            TodoResponse todo = todoService.getTodoById(id);
            
            // UpdateTodoRequest 생성 (현재 상태를 반대로 변경)
            claude.mcp.example.dto.UpdateTodoRequest updateRequest = 
                new claude.mcp.example.dto.UpdateTodoRequest(
                    todo.getTitle(),
                    todo.getDescription(),
                    !todo.getIsDone()
                );
            
            todoService.updateTodo(id, updateRequest);
            
            String status = !todo.getIsDone() ? "완료" : "미완료";
            redirectAttributes.addFlashAttribute("message", 
                "투두가 " + status + " 상태로 변경되었습니다.");
            redirectAttributes.addFlashAttribute("messageType", "success");
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "상태 변경 중 오류가 발생했습니다.");
            redirectAttributes.addFlashAttribute("messageType", "error");
        }
        
        return "redirect:/todos";
    }
    
    // 투두 삭제
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, 
                        RedirectAttributes redirectAttributes) {
        try {
            todoService.deleteTodo(id);
            redirectAttributes.addFlashAttribute("message", "투두가 성공적으로 삭제되었습니다.");
            redirectAttributes.addFlashAttribute("messageType", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "투두 삭제 중 오류가 발생했습니다.");
            redirectAttributes.addFlashAttribute("messageType", "error");
        }
        
        return "redirect:/todos";
    }
    
    // 루트 경로를 투두 목록으로 리다이렉트
    @GetMapping("/")
    public String root() {
        return "redirect:/todos";
    }
}
