package com.example.OssComponent.Ribbon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/products")
    public String getProducts() {
        // This will call the user service through Ribbon load balancing
        return restTemplate.getForObject("http://user-service/users", String.class);
    }
}
