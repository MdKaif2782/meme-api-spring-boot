package com.example.random_meme_api;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Random;

public class PostGrabber {
    public String[] subreddit = {
            "dankmemes",
            "memes",
            "dankvideos",
            "animemes",
            "goodanimemes",
            "cursedmemes"

    };
    String subredditName = subreddit[new Random().nextInt(subreddit.length)];
    String url = "https://www.reddit.com/r/" + subredditName + "/random/.json";
    String title;
    String ContentUrl;
    String subreddit_of_post;
    String author;
    String permalink;
    String postLink;
    Double postTime;
    Long rating;
    String postType;
    Boolean over_18;
    Boolean spoiler;
    public Post getPost(String sub) {
        URLConnection connection = null;
        try {
            if (sub.equals("null")){
                sub = subredditName;
            }
            url = "https://www.reddit.com/r/" + sub + "/top.json?limit=100";
            connection = new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.connect();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new java.io.InputStreamReader((java.io.InputStream) connection.getContent()));
            JSONObject data = (JSONObject) jsonObject.get("data");
            JSONArray children = (JSONArray) data.get("children");
            JSONObject data3 = (JSONObject) children.get(new Random().nextInt(children.size()));
            JSONObject data4 = (JSONObject) data3.get("data");
            title = (String) data4.get("title");
            ContentUrl = (String) data4.get("url");
            subreddit_of_post = "r/"+data4.get("subreddit");
            author = "u/"+data4.get("author");
            permalink = (String) data4.get("permalink");
            postLink = "https://www.reddit.com" + permalink;
            postTime = (Double) data4.get("created_utc");
            rating = (Long) data4.get("score");
            postType = (String) data4.get("post_hint");
            over_18 = (Boolean) data4.get("over_18");
            spoiler = (Boolean) data4.get("spoiler");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new Post(title, ContentUrl, subreddit_of_post, author, permalink, postLink, postTime, rating, postType, over_18, spoiler);
    }


}
