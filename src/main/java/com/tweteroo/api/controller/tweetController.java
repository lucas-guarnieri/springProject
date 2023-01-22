package com.tweteroo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;

@RestController
@RequestMapping("/tweets")

public class tweetController {

    @PostMapping
    public void create(@RequestBody TweetDTO req) {
        System.out.println(req); // TODO:remove system.out
    }
}
