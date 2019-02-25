package com.cleeng.api.domain;

import java.io.Serializable;

public class Answer implements Serializable {

    public String questionId;
    public String question;
    public String value;

    public Answer() {

    }

    public Answer(String questionId, String question, String value) {
        this.questionId = questionId;
        this.question = question;
        this.value = value;
    }
}
