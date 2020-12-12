package com.carwash.app.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("contact-us")
    public String contactUs(){

        return "contact_us";
    }

    @RequestMapping("/temp-home")
    public String tempHome(){

        return "partials/master";
    }
}
