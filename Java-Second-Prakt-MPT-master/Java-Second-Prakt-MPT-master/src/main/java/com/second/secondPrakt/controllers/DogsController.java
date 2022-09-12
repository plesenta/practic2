package com.second.secondPrakt.controllers;

import com.second.secondPrakt.models.Dogs;
import com.second.secondPrakt.posts.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dogs")
public class DogsController {
    @Autowired
    private DogsRepository dogsRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<Dogs> dogs = dogsRepository.findAll();
        model.addAttribute("dogs", dogs);
        return "/Dogs/index";
    }

    @GetMapping("/add")
    public String addView(Model model)
    {
        return "/Dogs/add";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam("breed") String breed,
                          @RequestParam("color") String color,
                          @RequestParam("colorOfEys") String colorOfEys,
                          @RequestParam("weight") Double weight,
                          @RequestParam("height") Double height,
                          Model model)
    {
        Dogs dogsOne = new Dogs(breed, color, colorOfEys, weight, height);
        dogsRepository.save(dogsOne);
        return "redirect:/dogs/";
    }

    @GetMapping("/search")
    public  String getSearchElement(@RequestParam("title") String title, Model model)
    {
        List<Dogs> dogsList = dogsRepository.findByBreedContains(title);
        model.addAttribute("dogs", dogsList);
        return "/Dogs/index";
    }
}
