package com.example.OssComponent.Hystrix;

import com.example.hystrixdemo.service.RemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    private final RemoteService remoteService;

    public HystrixController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @GetMapping("/call-remote")
    public String callRemoteService() {
        return remoteService.callRemoteService();
    }
}

