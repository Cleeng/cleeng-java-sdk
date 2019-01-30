package com.cleeng.api.domain;

import java.io.Serializable;

public class Question implements Serializable {

    public String key;
    public boolean required;
    public boolean enabled;
    public boolean enabledByDefault;
    public String value;
    public String question;

    public Question() {

    }

    public Question(String key,
                    boolean required,
                    boolean enabled,
                    boolean enabledByDefault,
                    String value,
                    String question) {
        this.key = key;
        this.required = required;
        this.enabled = enabled;
        this.enabledByDefault = enabledByDefault;
        this.value = value;
        this.question = question;
    }
}
