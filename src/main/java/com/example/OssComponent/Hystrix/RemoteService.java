package com.example.OssComponent.Hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteService {

    private final RestTemplate restTemplate;

    public RemoteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //annotion for wraping the method for fault tolerance
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String callRemoteService() {
        return restTemplate.getForObject("http://example.com/failing-service", String.class);
    }

    public String fallbackMethod() {
        return "Fallback response: The remote service is currently unavailable.";
    }
}
