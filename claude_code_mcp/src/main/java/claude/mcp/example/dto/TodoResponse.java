package claude.mcp.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    
    private Long id;
    private String title;
    private String description;
    private Boolean isDone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
