package mk.ukim.finki.emt.onlinemagazine.reaction.domain.repository;

import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleId;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.Reaction;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ReactionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction, ReactionId> {
}
