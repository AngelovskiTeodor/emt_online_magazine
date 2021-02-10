package mk.ukim.finki.emt.onlinemagazine.comment.domain.repository;

import mk.ukim.finki.emt.onlinemagazine.comment.domain.model.ArticleId;
import mk.ukim.finki.emt.onlinemagazine.comment.domain.model.Comment;
import mk.ukim.finki.emt.onlinemagazine.comment.domain.model.CommentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, CommentId> {
    List<Comment> findByArticleId(ArticleId articleId);
}
