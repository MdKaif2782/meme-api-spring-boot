package com.example.random_meme_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/api")
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
