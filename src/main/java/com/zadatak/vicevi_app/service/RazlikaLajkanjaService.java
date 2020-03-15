package com.zadatak.vicevi_app.service;

import org.springframework.stereotype.Component;

@Component("razlikaLajkanjaService")
public class RazlikaLajkanjaService {
    public Integer izracunajRazlikuLajkova(Integer likes ,Integer dislikes){

        return likes - dislikes;

    }
}
