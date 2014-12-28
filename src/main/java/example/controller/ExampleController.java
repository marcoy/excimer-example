package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/example")
public class ExampleController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "World";
    }
}
