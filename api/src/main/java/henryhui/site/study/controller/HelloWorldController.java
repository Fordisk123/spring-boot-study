package henryhui.site.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 */
@RestController
@Slf4j
public class HelloWorldController {
    @RequestMapping("/hello")
    public String helloWorld() {
        log.info("In Hello world!");
        return "Hello World";
    }
}
