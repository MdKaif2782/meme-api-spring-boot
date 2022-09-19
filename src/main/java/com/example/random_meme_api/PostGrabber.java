package com.example.random_meme_api;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class PostGrabber {
    public String[] subreddit = {
            "dankmemes",
            "memes",
            "dankvideos,",
            "wholesomememes",
            "wholesomevideos",
            "animemes",
            "goodanimemes",
            "cursedmemes",
            "okbuddyretard",

    };
    String subredditName = subreddit[new Random().nextInt(subreddit.length)];
    String url = "https://www.reddit.com/r/" + subredditName + "/random/.json";
    String title;
    String ContentUrl;
    String subreddit_of_post;
    String author;
    String permalink;
    String postLink;
    String postTime;
    String rating;
    String postType;
    Boolean over_18;
    Boolean spoiler;

    public Post getPost() {
        URLConnection connection = null;
        try {
            connection = new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.connect();
            //parse the json
            JSONParser parser = new JSONParser(connection.getInputStream());
            JSONArray json = (JSONArray) parser.parse();
            JSONObject data = (JSONObject) json.get(0);
            JSONObject data2 = (JSONObject) data.get("data");
            JSONArray children = (JSONArray) data2.get("children");
            JSONObject data3 = (JSONObject) children.get(0);
            JSONObject data4 = (JSONObject) data3.get("data");
            title = (String) data4.get("title");
            ContentUrl = (String) data4.get("url");
            subreddit_of_post = (String) data4.get("subreddit");
            author = (String) data4.get("author");
            permalink = (String) data4.get("permalink");
            postLink = "https://www.reddit.com" + permalink;
            postTime = (String) data4.get("created_utc");
            rating = (String) data4.get("score");
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
    public Post getPost(String sub) {
        URLConnection connection = null;
        try {
            url = "https://www.reddit.com/r/" + sub + "/random/.json";
            connection = new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.connect();
            //parse the json
            JSONParser parser = new JSONParser(connection.getInputStream());
            JSONArray json = (JSONArray) parser.parse();
            JSONObject data = (JSONObject) json.get(0);
            JSONObject data2 = (JSONObject) data.get("data");
            JSONArray children = (JSONArray) data2.get("children");
            JSONObject data3 = (JSONObject) children.get(0);
            JSONObject data4 = (JSONObject) data3.get("data");
            title = (String) data4.get("title");
            ContentUrl = (String) data4.get("url");
            subreddit_of_post = (String) data4.get("subreddit");
            author = (String) data4.get("author");
            permalink = (String) data4.get("permalink");
            postLink = "https://www.reddit.com" + permalink;
            postTime = (String) data4.get("created_utc");
            rating = (String) data4.get("score");
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
