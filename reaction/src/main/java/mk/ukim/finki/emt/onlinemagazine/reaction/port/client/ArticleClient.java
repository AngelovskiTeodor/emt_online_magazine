package mk.ukim.finki.emt.onlinemagazine.reaction.port.client;

import mk.ukim.finki.emt.onlinemagazine.reaction.application.ArticleService;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.Article;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class ArticleClient implements ArticleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleClient.class);

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public ArticleClient(@Value("${app.article.url}") String serverUrl, @Value("${app.article.connect-timeout-ms}") int connectTimeout, @Value("${app.article.read-timeout-ms}") int readTimeout) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }

    @Override
    public List<Article> findAll() {
        try {
            return restTemplate.exchange(
                    uri().path("/api/articles").build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Article>>() {}
            ).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving articles", ex);
            return Collections.emptyList();
        }

    }

    @Override
    public Article findById(ArticleId articleId) {
        try {
            return restTemplate.exchange(
                    uri().path("/api/articles/"+articleId.getId()).build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Article>() {}
            ).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving product by id", ex);
            return null;
        }
    }
}
