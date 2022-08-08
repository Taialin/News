package com.example.news.services.impl;


import com.example.news.dob.MyNews;
import com.example.news.dob.NewsCategory;
import com.example.news.services.NewsCategoryServices;
import com.example.news.services.NewsServices;
import com.example.news.services.PriceService;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class RssFeedView {

    @Autowired
    private NewsCategoryServices newsCategoryServices;

    @Autowired
    private NewsServices newsServices;

    @Autowired
    private PriceService priceService;


    public void persistAllNews(String url) throws IOException, FeedException {

        URL feedSource = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));
        List<MyNews> entries = new ArrayList<>();
        List<NewsCategory> myCatygories = new ArrayList<>(newsCategoryServices.findAll());
        for (SyndEntry entry : feed.getEntries()) {
            Set<NewsCategory> categories = new HashSet<>();
            for (SyndCategory category : entry.getCategories()) {
                for (NewsCategory o : myCatygories) {
                    if (category.getName().equals(o.getNews_category())) {
                        categories.add(o);
                    }
                }
            }
            entries.add(
                    new MyNews(
                            entry.getTitle(),
                            entry.getLink(),
                            entry.getPublishedDate().toString(),
                            entry.getAuthor().toString(),
                            entry.getUri(),
                            entry.getDescription().getValue(),
                            priceService.findAllById(1L),
                            categories
                    )
            );
        }
        for (MyNews item : entries) {
            newsServices.save(item);
        }
    }
}
