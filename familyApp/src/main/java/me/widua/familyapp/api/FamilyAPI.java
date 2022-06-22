package me.widua.familyapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FamilyAPI {

    @GetMapping("/")
    public String test(){
        return "Hello world!, db work" ;
    }




}
