package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    public List<Tweet> findAlltTweets() {
        return repository.findAll();
    }

    public List<Tweet> findByUser(String userName) {
        return repository.findByUsername(userName);
    }

    // public Page<Tweet> findAll(Pageable pageable) {
    // int page = Integer.parseInt(pageable.getPageParameter());
    // int size = Integer.parseInt(pageable.getSizeParameter());
    // PageRequest pageRequest = PageRequest.of(
    // page,
    // size);

    // return new PageImpl<>(repository.findAll(),
    // pageRequest, size);

    // }

}
