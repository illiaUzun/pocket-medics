package YELL.main.service.impl;


import YELL.main.domain.Comment;
import YELL.main.repository.CommentRepository;
import YELL.main.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Comment.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * Save a comment.
     *
     * @param comment the entity to save
     * @return the persisted entity
     */
    @Override
    public Comment save(Comment comment) {
        log.debug("Request to save Comment : {}", comment);        return commentRepository.save(comment);
    }

    /**
     * Get all the comments.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Comment> findAll(Pageable pageable) {
        log.debug("Request to get all Comments");
        return commentRepository.findAll(pageable);
    }


    /**
     * Get one comment by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Comment> findOne(Long id) {
        log.debug("Request to get Comment : {}", id);
        return commentRepository.findById(id);
    }

    /**
     * Delete the comment by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Comment : {}", id);
        commentRepository.deleteById(id);
    }
}
