package com.zadatak.vicevi_app.controller;

import com.zadatak.vicevi_app.model.Category;
import com.zadatak.vicevi_app.model.Joke;
import com.zadatak.vicevi_app.service.CategoryService;
import com.zadatak.vicevi_app.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;
    @Autowired
    private CategoryService categoryService;

    public JokeController() {
    }

    @GetMapping("/")
    public String findJokes(HttpServletRequest request,Model model, @ModelAttribute(value="joke") Joke joke) {

        int page = 0; //default page number is 0 (yes it is weird)
        int size = 10; //default page size is 10

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        Page<Joke> jokes = jokeService.findAll(PageRequest.of(page, size));

        model.addAttribute("jokes", jokes);


        return "showJokes";
    }

    @PostMapping("/addJoke")
    public String addJoke(@Valid @ModelAttribute(value="joke") Joke joke, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()){

            Category category = new Category();
            model.addAttribute("category", category);
            List<Category> categoriesList = categoryService.findAll();
            model.addAttribute("categories", categoriesList);

            return "JokeForm";
        }
        jokeService.save(joke);

        return "redirect:";
    }

    @GetMapping("/addJoke")
    public String addJoke(Model model)
    {

        Joke joke = new Joke();
        Category category = new Category();
        model.addAttribute("joke", joke);
        model.addAttribute("category", category);
        List<Category> categoriesList = categoryService.findAll();
        model.addAttribute("categories", categoriesList);

        return "JokeForm";
    }

    @RequestMapping("/addLike/{id}/{page}")
    public String addLike(@PathVariable(name = "id") String id, @PathVariable(name = "page") String page) {
        jokeService.digniLike(Integer.valueOf(id));
        int currentPage = Integer.parseInt(page) + 1;
        return "redirect:/?page=" + currentPage;
    }

    @RequestMapping("/addDislike/{id}/{page}")
    public String addDislike(@PathVariable(name = "id") String id, @PathVariable(name = "page") String page) {
        jokeService.digniDislike(Integer.valueOf(id));
        int currentPage = Integer.parseInt(page) + 1;
        return "redirect:/?page=" + currentPage;
    }




}
