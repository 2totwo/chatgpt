package com.example.service.adoption;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/gpt")
    public String gpt(){
        return "gpt"; // gpt.html
    }
}
