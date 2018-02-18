package br.com.tw.lunchandlearn.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/")
    String home() {
        return "Home";
    }

}
