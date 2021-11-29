package ru.itmo.wp.model.service;

import com.google.common.base.Strings;
import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.repository.ArticleRepository;
import ru.itmo.wp.model.repository.impl.ArticleRepositoryImpl;

import java.util.List;

public class ArticleService {
    private final ArticleRepository articleRepository = new ArticleRepositoryImpl();

    public void validateArticle(Article article) throws ValidationException {
        if (Strings.isNullOrEmpty(article.getTitle())) {
            throw new ValidationException("Title required");
        }

        if (article.getTitle().length() > 255) {
            throw new ValidationException("Title can't be longer than 255 letters");
        }
        if (Strings.isNullOrEmpty(article.getText())) {
            throw new ValidationException("Text required");
        }
        if (article.getText().length() > 5000) {
            throw new ValidationException("Text can't be longer than 5000 letters");
        }
        if (new UserService().find(article.getUserId()) == null) {
            throw new ValidationException("User does not exist");
        }
    }

    public void createArticle(Article article) {
        articleRepository.save(article);
    }

    public List<Article> findAll() {
        List<Article> ans = articleRepository.findAll();
        return ans;
    }
}
