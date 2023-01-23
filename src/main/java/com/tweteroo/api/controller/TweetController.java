package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody TweetDTO req) {
        service.createTweet(req);
    }

    @GetMapping
    public List<Tweet> getTweets() {
        return service.findAlltTweets();
    }

    @GetMapping("/{username}")
    public List<Tweet> getTweetsByUser(@PathVariable String username) {
        return service.findByUser(username);
    }

    // @GetMapping
    // public Page<Tweet> getTweets(@PageableDefault(page = 0, size = 5) Pageable
    // page) {
    // return service.findAll(page);
    // }
}
