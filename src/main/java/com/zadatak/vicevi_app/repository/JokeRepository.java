package com.zadatak.vicevi_app.repository;

import com.zadatak.vicevi_app.model.Joke;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface JokeRepository extends CrudRepository<Joke, Long>{

    @Transactional
    @Modifying
    @Query(value = "UPDATE public.joke j SET likes = likes+1 WHERE j.id = ?1", nativeQuery = true)
    void digniLike(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE public.joke j SET dislikes = dislikes+1 WHERE j.id = ?1", nativeQuery = true)
    void digniDislike(Integer id);

}
