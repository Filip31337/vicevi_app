package com.zadatak.vicevi_app.controller;

import com.zadatak.vicevi_app.model.Category;
import com.zadatak.vicevi_app.model.Joke;
import com.zadatak.vicevi_app.service.CategoryService;
import com.zadatak.vicevi_app.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

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
    public String findJokes(Model model, @ModelAttribute(value="joke") Joke joke) {

        List<Joke> jokes = jokeService.findAll();
        jokes.sort((Joke joke1, Joke joke2)-> {
            return (int) ((joke2.getLikes()-joke2.getDislikes())-(joke1.getLikes()-joke1.getDislikes()));
        });
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

    @RequestMapping("/addLike/{id}")
    public String addLike(@PathVariable(name = "id") String id) {
        jokeService.digniLike(Integer.valueOf(id));
        return "redirect:/";
    }

    @RequestMapping("/addDislike/{id}")
    public String addDislike(@PathVariable(name = "id") String id) {
        jokeService.digniDislike(Integer.valueOf(id));
        return "redirect:/";
    }

}
