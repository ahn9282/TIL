package claude.mcp.example.repository;

import claude.mcp.example.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    // 완료 상태별 조회
    List<Todo> findByIsDone(Boolean isDone);
    
    // 제목으로 검색
    List<Todo> findByTitleContainingIgnoreCase(String title);
}
