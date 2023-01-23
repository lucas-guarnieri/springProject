package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByUsername(String username);
}
