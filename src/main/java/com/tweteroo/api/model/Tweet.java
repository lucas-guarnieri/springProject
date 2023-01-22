package com.tweteroo.api.model;

import com.tweteroo.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class Tweet {

    public Tweet(TweetDTO data, String avatarData) {
        this.username = data.username();
        this.avatar = avatarData;
        this.text = data.tweet();
    }

    public Tweet(TweetDTO data) {
        this.username = data.username();
        this.avatar = null;
        this.text = data.tweet();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false, length = 280)
    private String text;

    public String getUserName() {
        return this.username;
    }
}
