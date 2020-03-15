package com.zadatak.vicevi_app.service;

import com.zadatak.vicevi_app.model.Category;
import com.zadatak.vicevi_app.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        List<Category> categories = (List<Category>) repository.findAll();

        return categories;
    }
}
