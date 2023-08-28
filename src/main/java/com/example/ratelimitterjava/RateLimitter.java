package com.example.ratelimitterjava;


// Rate limitter limits the total number of requests to the server per minute. In this case its 2 requests per minute

// This Rate Limitter uses Token Bucket Algorithm


// Note: This class is Singleton as only 1 rate limitter is needed throughout the application
public class RateLimitter {

    private static int tokensInBucket = 2;
    private static RateLimitter single_instance = null;

    private RateLimitter()
    {}

    public static RateLimitter RateLimitter(){
        if(single_instance == null){
            single_instance = new RateLimitter();
        }
        return single_instance;
    }

    public int getToken(){
        return tokensInBucket;
    }
    public void increaseToken(int number){
        this.tokensInBucket +=number;
    }

    public void useToken(){
        this.tokensInBucket -=1;
    }

    public boolean checkLimit(){
        if(this.tokensInBucket >0){
            return false;
        }
        else
        {
            return true;
        }

    }
}
