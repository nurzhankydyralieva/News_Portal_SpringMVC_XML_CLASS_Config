package com.epam.project.controllers;

import com.epam.project.models.News;
import com.epam.project.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("news", newsService.findAll());
        return "index";
    }

    @GetMapping("/news/{id}")
    public String showNews(@PathVariable("id") int id, Model model) {
        model.addAttribute("newsPage", newsService.findById(id));
        return "viewNews";
    }

    @GetMapping("/news/new")
    public String newNews(@ModelAttribute("newsPage") News news) {
        return "newNews";
    }

    @PostMapping("/news")
    public String createNews(@ModelAttribute("newsPage") @Valid News news,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newNews";
        }

        newsService.save(news);
        return "redirect:/";
    }

    @GetMapping("/news/{id}/edit")
    public String editNews(Model model, @PathVariable("id") int id) {
        model.addAttribute("newsPage", newsService.findById(id));
        return "editNews";
    }

    @PatchMapping("/news/{id}")
    public String updateNews(@ModelAttribute("newsPage") @Valid News news,
                             BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "editNews";
        }
        newsService.updateNews(id, news);
        return "redirect:/";
    }


//    @DeleteMapping("/news/{id}")
//    public String deleteNews(@PathVariable("id") int id) {
//        newsService.delete(id);
//        return "redirect:/";
//    }
@DeleteMapping("/news/{id}")
public String deleteNews(@PathVariable("id") int id) {
    newsService.findByNewsId(id);
    return "redirect:/";
}
}
