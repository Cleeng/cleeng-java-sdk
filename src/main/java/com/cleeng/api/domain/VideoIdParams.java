package com.cleeng.api.domain;

import java.io.Serializable;

public class VideoIdParams implements Serializable {

    public String publisherToken;
    public String videoId;

    public VideoIdParams(String publisherToken, String videoId) {
        this.publisherToken = publisherToken;
        this.videoId = videoId;
    }

    public VideoIdParams(String videoId) {
        this.videoId = videoId;
    }
}
