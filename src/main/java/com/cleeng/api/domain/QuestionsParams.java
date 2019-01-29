package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class QuestionsParams implements Serializable {

    public String publisherToken;

    public List<Question> questions;

    public QuestionsParams() {

    }

    public QuestionsParams(String publisherToken, List<Question> questions) {
        this.publisherToken = publisherToken;
        this.questions = questions;
    }

    public QuestionsParams(String publisherToken) {
        this.publisherToken = publisherToken;
    }
}
