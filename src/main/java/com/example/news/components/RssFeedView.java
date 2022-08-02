package com.example.news.components;


import com.example.news.dob.News;
import com.example.news.dob.NewsCategory;
import com.example.news.services.NewsCategoryServices;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class RssFeedView  {

    @Autowired
    NewsCategoryServices newsCategoryServices;

    private final String url;


    public RssFeedView(String url, NewsCategoryServices newsCategoryServices){
        this.url = url;
        this.newsCategoryServices = newsCategoryServices;

    }

    public List<News> getAll() throws IOException, FeedException {

        URL feedSource = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));
        List<News> entries = new ArrayList<>();
        List<NewsCategory> myCatygories = new ArrayList<>(newsCategoryServices.findAll());
        for (SyndEntry entry: feed.getEntries()) {
            List<String> categories = new ArrayList<>();
            for ( SyndCategory category: entry.getCategories()) {
                for (NewsCategory o : myCatygories){
                    if(category.getName().equals(o.getNews_category())){
                      categories.add(category.getName());}
                   // System.out.println(categories);
            }}
            entries.add(
                    new News(
                            entry.getTitle(),
                            entry.getLink(),
                            entry.getPublishedDate().toString(),
                            entry.getAuthor().toString(),
                            String.join("," , categories),
                            entry.getUri(),
                            entry.getDescription().getValue()
                    )
            );
        }

        return entries;
    }

    public  List<NewsCategory> getCategory() throws IOException, FeedException{

        URL feedSource2 = new URL((url));
        SyndFeedInput input2 = new SyndFeedInput();
        SyndFeed syndFeed = input2.build(new XmlReader(feedSource2));

        List<NewsCategory> cat = new ArrayList<>(10);

        for (SyndEntry entry: syndFeed.getEntries()){
            List<String> categories = new ArrayList<>();
            for ( SyndCategory category: entry.getCategories()) {

            cat.add(
                    new NewsCategory(
                           category.getName())
            );
            }


    }

        return cat;


    }
}
