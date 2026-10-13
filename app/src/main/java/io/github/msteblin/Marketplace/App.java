package io.github.msteblin.Marketplace;

import io.github.msteblin.MoySkladAPI.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        HelloWorld.Hello();
        SpringApplication.run(App.class, args);
    }
}
