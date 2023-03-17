package com.epam.project.controllers;

import com.epam.project.dao.NewsDAO;
import com.epam.project.models.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class NewsController {
    private NewsDAO newsDAO;

    @Autowired
    public NewsController(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("news", newsDAO.indexPage());
        return "index";
    }

    @GetMapping("/news/{id}")
    public String showNews(@PathVariable("id") int id, Model model) {
        model.addAttribute("newsPage", newsDAO.showNews(id));
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

        newsDAO.saveNews(news);
        return "redirect:/";
    }

    @GetMapping("/news/{id}/edit")
    public String editNews(Model model, @PathVariable("id") int id) {
        model.addAttribute("newsPage", newsDAO.showNews(id));
        return "editNews";
    }

    @PatchMapping("/news/{id}")
    public String updateNews(@ModelAttribute("newsPage") @Valid News news,
                             BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "editNews";
        }
        newsDAO.updateNews(id, news);
        return "redirect:/";
    }


    @DeleteMapping("/news/{id}")
    public String deleteNews(@PathVariable("id") int id) {
        newsDAO.deleteNews(id);
        return "redirect:/";
    }
}
