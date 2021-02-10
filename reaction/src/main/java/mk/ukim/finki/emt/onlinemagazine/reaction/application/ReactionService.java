package mk.ukim.finki.emt.onlinemagazine.reaction.application;

import mk.ukim.finki.emt.onlinemagazine.reaction.application.form.ArticleReactionForm;
import mk.ukim.finki.emt.onlinemagazine.reaction.application.form.ReactionForm;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.event.ArticleReactionCreated;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleReaction;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleReactionId;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.Reaction;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ReactionId;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.repository.ArticleReactionRepository;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.repository.ReactionRepository;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity.Popularity;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ReactionService {
    private final ReactionRepository reactionRepository;

    private final ArticleReactionRepository articleReactionRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final Validator validator;

    public ReactionService(ReactionRepository reactionRepository, ArticleReactionRepository articleReactionRepository, ApplicationEventPublisher applicationEventPublisher, Validator validator) {
        this.reactionRepository = reactionRepository;
        this.articleReactionRepository = articleReactionRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.validator = validator;
    }

    public ReactionId createReaction (@NonNull ReactionForm reactionForm) {
        Objects.requireNonNull(reactionForm,"Reaction Form can not be null");
        var constraintViolations = validator.validate(reactionForm);

        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The ReactionForm is not valid", constraintViolations);
        }

        var newReaction = reactionRepository.saveAndFlush(toDomainModel(reactionForm));
        return newReaction.id();
    }

    public ArticleReactionId createArticleReaction (@NonNull ArticleReactionForm articleReactionForm) {
        Objects.requireNonNull(articleReactionForm,"ArticleReactionForm Form can not be null");
        var constraintViolations = validator.validate(articleReactionForm);

        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The ArticleReactionForm is not valid", constraintViolations);
        }

        ArticleReaction newArticleReaction = articleReactionRepository.saveAndFlush(toDomainModel(articleReactionForm));
        Popularity newPopularity = new Popularity();
        List<ArticleReaction> articleReactions = articleReactionRepository.findAllByArticleId(newArticleReaction.getArticleId());
        for (ArticleReaction articleReaction: articleReactions) {
            newPopularity = newPopularity.addPopularity(reactionRepository.findById(articleReaction.getReactionId()).orElseThrow(RuntimeException::new).getBasePopularity());
        }
        ArticleReactionCreated event = new ArticleReactionCreated(newArticleReaction.getArticleId(), newPopularity, Instant.now());
        applicationEventPublisher.publishEvent(event);
        return newArticleReaction.id();
    }

    @NonNull
    public Optional<Reaction> findById(@NonNull ReactionId reactionId) {
        Objects.requireNonNull(reactionId, "reactionId must not be null");
        return reactionRepository.findById(reactionId);
    }

    @NonNull
    private Reaction toDomainModel(@NonNull ReactionForm reactionForm) {
        Reaction reaction = new Reaction(reactionForm.getDescription(), reactionForm.getBasePopularity());
        return reaction;
    }

    @NonNull
    private ArticleReaction toDomainModel(@NonNull ArticleReactionForm articleReactionForm) {
        ArticleReaction articleReaction = new ArticleReaction(articleReactionForm.getArticleId(), articleReactionForm.getAuthor(), articleReactionForm.getReactionId());
        return articleReaction;
    }
}