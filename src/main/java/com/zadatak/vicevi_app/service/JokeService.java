package com.zadatak.vicevi_app.service;

import com.zadatak.vicevi_app.model.Joke;
import com.zadatak.vicevi_app.repository.JokeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class JokeService {


    @Autowired
    private JokeRepository repository;

    public List<Joke> findAll(){
        List<Joke> jokes = (List<Joke>) repository.findAll();

        return jokes;
    }

    public Optional<Joke> findById(Long id) {

        return repository.findById(id);
    }

    public void digniLike(Integer id) {
        repository.digniLike(id);
    }

    public void digniDislike(Integer id) {
        repository.digniDislike(id);
    }

    public Joke save(Joke joke){
        return repository.save(joke);
    }


    public Page<Joke> findAll(PageRequest paging) {
        Page<Joke> paginatedjokes = repository.findAll(paging);

        return paginatedjokes;
    }
}
