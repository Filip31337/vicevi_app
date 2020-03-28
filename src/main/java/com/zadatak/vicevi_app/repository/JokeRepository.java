package com.zadatak.vicevi_app.repository;

import com.zadatak.vicevi_app.model.Joke;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface JokeRepository extends JpaRepository<Joke, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE public.joke j SET likes = likes+1 WHERE j.id = ?1", nativeQuery = true)
    void digniLike(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE public.joke j SET dislikes = dislikes+1 WHERE j.id = ?1", nativeQuery = true)
    void digniDislike(Integer id);

    @Override
    @Query(value = "SELECT * FROM public.joke ORDER BY (likes-dislikes) DESC", nativeQuery = true)
    Page<Joke> findAll(Pageable page);

}
