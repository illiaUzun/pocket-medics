package YELL.main.Services;

import YELL.main.Entities.Comment;
import YELL.main.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    public void addComment(Comment comment){
        repository.saveAndFlush(comment);
    }

}
