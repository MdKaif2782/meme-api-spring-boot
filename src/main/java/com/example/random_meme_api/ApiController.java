package com.example.random_meme_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/")
    public String index() {
        return "Hello motherfucker :)\nThis isn't he page for api calls,\ngo to https://random-meme-api-spring.herokuapp.com/api/meme " +
                "for api calls\n" +
                "You can also add a parameter to the url to get a meme from a specific subreddit\n"+"" +
                "Example: https://random-meme-api-spring.herokuapp.com/api/meme?subreddit=memes";
    }
    public String api() {
        return "Hello from API!";
    }
    //sort by top added
    @GetMapping("/api/meme")
    public Post getMemeFromSubreddit(@RequestParam(value = "subreddit",defaultValue ="null") String subreddit) {
        System.out.println("Request for meme from subreddit: " + subreddit);
        PostGrabber postGrabber = new PostGrabber();
        return postGrabber.getPost(subreddit);
    }

}
