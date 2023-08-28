package com.example.ratelimitterjava;


// This is an injector thread used to inject tokens every minute into the bucket

public class tokenInjector extends Thread {
    RateLimitter limitter = RateLimitter.RateLimitter();

    public void run()
    {
        while(true){
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis()-start<60000);
            int numberOfTokens = limitter.getToken();
            limitter.increaseToken(2-numberOfTokens);

        }
    }
}
