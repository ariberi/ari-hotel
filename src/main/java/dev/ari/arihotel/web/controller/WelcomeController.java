package dev.ari.arihotel.web.controller;

import io.micrometer.common.util.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String getWelcome(@RequestParam(value = "name", required = false) String name) {
        // the name parameter is on the browser URL http://localhost:8080/welcome?name=Ariel
        String greeting = "Welcome to Ari Hotel";
        if (StringUtils.isNotBlank(name)) {
            greeting = greeting + ", " + name + "!";
        } else {
            greeting = greeting + ", Universe!";
        }
        return "<html><body><h1>" + greeting + "</h1></body></html>";
    }


}
