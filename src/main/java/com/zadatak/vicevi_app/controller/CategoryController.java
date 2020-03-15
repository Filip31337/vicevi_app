package com.zadatak.vicevi_app.controller;

import com.zadatak.vicevi_app.model.Category;
import com.zadatak.vicevi_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController() {
    }

    @GetMapping("/showCategories")
    public String findCategories(Model model) {

        List<Category> categories = (List<Category>) categoryService.findAll();

        model.addAttribute("categories", categories);

        return "showCategories";
    }
}