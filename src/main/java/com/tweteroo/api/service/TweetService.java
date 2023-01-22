package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Tweet createTweet(TweetDTO data) {
        String tweetAuthor = new Tweet(data).getUserName();
        String avatar = userRepository.findByUsername(tweetAuthor).getAvatar();
        return repository.save(new Tweet(data, avatar));
    }

}
