package ru.itmo.wp.web.page;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.service.ArticleService;
import ru.itmo.wp.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ArticlePage {
    private final ArticleService articleService = new ArticleService();

    private void action(HttpServletRequest request, Map<String, Object> view) {
        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("message", "Please, log in.");
            throw new RedirectException("/index");
        }
    }

    private void createArticle(HttpServletRequest request, Map<String, Object> view) throws ValidationException {
        Article article = new Article();
        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("message", "Please, log in.");
            throw new RedirectException("/index");
        }
        article.setTitle(request.getParameter("title"));
        article.setText(request.getParameter("text"));

        articleService.validateArticle(article);
        articleService.createArticle(article);

        request.getSession().setAttribute("message", "You have successfully created an article!");
        throw new RedirectException("/index");
    }


}
