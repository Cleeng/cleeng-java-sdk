package com.cleeng.api.domain;

import java.io.Serializable;

public class CaptureQuestion implements Serializable {

    public String key;
    public boolean enabled;
    public boolean required;

    public CaptureQuestion(String key, boolean enabled, boolean required) {
        this.key = key;
        this.enabled = enabled;
        this.required = required;
    }
}
