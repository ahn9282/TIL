package claude.mcp.example.repository;

import claude.mcp.example.entity.Todo;
import claude.mcp.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserOrderByCreatedAtDesc(User user);
    Optional<Todo> findByIdAndUser(Long id, User user);
    void deleteByIdAndUser(Long id, User user);
}
