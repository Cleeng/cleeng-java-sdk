package com.cleeng.api;

public class CleengBuilder {

    private String propertiesPath = "src/main/resources/config.properties";
    private int socketTimeout = -1;
    private int connectTimeout = -1;
    private int requestTimeout = -1;
    private int retryCount = 0;
    private String platformUrl;
    private String platformUrlSandbox;
    private String publisherToken;
    private int useNonBlockingMode = 1;
    private boolean useSandbox = false;

    public CleengBuilder(String publisherToken) {
        this.publisherToken = publisherToken;
    }

    public CleengBuilder setPropertiesPath(String value) {
        this.propertiesPath = value;
        return this;
    }

    public CleengBuilder setSocketTimeout(int value) {
        this.socketTimeout = value;
        return this;
    }

    public CleengBuilder setConnectTimeout(int value) {
        this.connectTimeout = value;
        return this;
    }

    public CleengBuilder setRequestTimeout(int value) {
        this.requestTimeout = value;
        return this;
    }

    public CleengBuilder setRetryCount(int value) {
        this.retryCount = value;
        return this;
    }

    public CleengBuilder setPlatformUrl(String value) {
        this.platformUrl = value;
        return this;
    }

    public CleengBuilder setPlatformUrlSandbox(String value) {
        this.platformUrlSandbox = value;
        return this;
    }

    public CleengBuilder setUseSandbox(boolean value) {
        this.useSandbox = value;
        return this;
    }

    /**
     *
     * @param value - indicating whether to block: 0 - block (override properties), 1: do not block (override properties), -1: does not specify (properties still will be used to set this, if not found in properties it will be set to not block)
     * @return
     */
    public CleengBuilder setUseNonBlockingMode(int value) {
        this.useNonBlockingMode = value;
        return this;
    }

    public Cleeng build() {
        return new CleengImpl(this.platformUrl,
                this.platformUrlSandbox,
                this.useSandbox,
                this.publisherToken,
                this.propertiesPath,
                this.socketTimeout,
                this.connectTimeout,
                this.requestTimeout,
                this.retryCount,
                this.useNonBlockingMode
        );
    }
}

