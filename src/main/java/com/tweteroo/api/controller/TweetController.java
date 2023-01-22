package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
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
}
