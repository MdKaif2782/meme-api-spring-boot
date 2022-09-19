package com.example.random_meme_api;

import org.apache.tomcat.util.json.JSONParser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class PostGrabber {
    public String[] subreddit = {
            "r/dankmemes",
            "r/memes",
            "r/dankvideos,",
            "r/wholesomememes",
            "r/wholesomevideos",
            "r/animemes",
            "r/goodanimemes",
            "r/cursedmemes",
            "r/okbuddyretard",

    };
    String subredditName = subreddit[new Random().nextInt(subreddit.length)];
    String url = "https://www.reddit.com/" + subredditName + "/random/.json";
    String title;
    String ContentUrl;
    String subreddit_of_post;
    String author;
    String permalink;
    String postLink;
    String postTime;
    String rating;
    String postType;

    public Post getPost() {
        URLConnection connection = null;
        try {
            connection = new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.connect();
            //parse the json
            JSONParser parser = new JSONParser(connection.getInputStream());
            //get the json array

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Post(title, ContentUrl, subreddit_of_post, author, permalink, postLink, postTime, rating, postType);
    }


}
