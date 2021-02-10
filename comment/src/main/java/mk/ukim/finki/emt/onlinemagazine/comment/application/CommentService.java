package mk.ukim.finki.emt.onlinemagazine.comment.application;

import mk.ukim.finki.emt.onlinemagazine.comment.domain.model.ArticleId;
import mk.ukim.finki.emt.onlinemagazine.comment.domain.model.Comment;
import mk.ukim.finki.emt.onlinemagazine.comment.domain.model.CommentId;
import mk.ukim.finki.emt.onlinemagazine.comment.domain.repository.CommentRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @NonNull
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @NonNull
    public Optional<Comment> findById(@NonNull CommentId commentId) {
        Objects.requireNonNull(commentId, "commentId must not be null");
        return commentRepository.findById(commentId);
    }

    @NonNull
    public List<Comment> findByArticleId(@NonNull ArticleId articleId) {
        Objects.requireNonNull(articleId, "articleId must not be null");
        return commentRepository.findByArticleId(articleId);
    }
}
