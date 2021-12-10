package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.domain.Comment;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.security.Guest;
import ru.itmo.wp.service.PostService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PostPage extends Page {
    private final PostService postService;

    public PostPage(PostService postService) {
        this.postService = postService;
    }

    @Guest
    @GetMapping("/post/{id}")
    public String getPost(Model model, @PathVariable String id) {
        Post post = null;
        try {
            post = postService.findById(Long.parseLong(id));
        } catch (NumberFormatException ignored) {
        }
        if (post != null) {
            model.addAttribute("post", post);
            model.addAttribute("comments", post.getComments());
            model.addAttribute("comment", new Comment());
        }
        return "PostPage";
    }

    @Guest
    @PostMapping("/post/{id}")
    public String writeComment(Model model,
                               @Valid @ModelAttribute("comment") Comment comment,
                               BindingResult bindingResult,
                               HttpSession httpSession,
                               @PathVariable String id) {
        Post post = null;
        try {
            post = postService.findById(Long.parseLong(id));
        } catch (NumberFormatException ignored) {
        }

        if (post == null) {
            putMessage(httpSession, "Post not found");
            return "redirect:/";
        }

        model.addAttribute("post", post);
        model.addAttribute("comments", post.getComments());
        model.addAttribute("comment", comment);

        if (bindingResult.hasErrors()) {
            return "PostPage";
        }

        postService.writeComment(getUser(httpSession), post, comment);
        putMessage(httpSession, "You published new comment");
        return "redirect:/post/" + id;
    }
}
