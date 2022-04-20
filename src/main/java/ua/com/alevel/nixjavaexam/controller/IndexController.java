package ua.com.alevel.nixjavaexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @GetMapping
    public void index(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "/index.html");
        httpServletResponse.setStatus(302);
    }
}
