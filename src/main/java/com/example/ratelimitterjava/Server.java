package com.example.ratelimitterjava;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Requests are only successfull if there are tokens in the bucket
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
public class Server {

    RateLimitter limitter = RateLimitter.RateLimitter();

    @GetMapping("/request")
    public String mainServer(){
        if(!limitter.checkLimit())
        {
            limitter.useToken();
            return "Success";
        }
        else
        {
            return "Failed due to rate limit";
        }

    }

}
