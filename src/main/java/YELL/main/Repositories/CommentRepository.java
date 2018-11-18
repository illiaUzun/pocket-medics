package YELL.main.Repositories;

import YELL.main.Entities.Account;
import YELL.main.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
