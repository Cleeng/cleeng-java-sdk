package com.cleeng.api;

public class Config {

    public int socketTimeout = -1;
    public int connectTimeout = -1;
    public int requestTimeout = -1;
    public int retryCount = 0;
    public boolean useNonBlockingMode = false;
    public String platformUrl;
    public String platformUrlSandbox;
    public boolean useSandbox;

    public Config(int socketTimeout,
                  int connectTimeout,
                  int requestTimeout,
                  int retryCount,
                  boolean useNonBlockingMode,
                  String platformUrl,
                  String platformUrlSandbox,
                  boolean useSandbox) {

        this.socketTimeout = socketTimeout;
        this.connectTimeout = connectTimeout;
        this.requestTimeout = requestTimeout;
        this.retryCount = retryCount;
        this.useNonBlockingMode = useNonBlockingMode;
        this.platformUrl = platformUrl;
        this.platformUrlSandbox = platformUrlSandbox;
        this.useSandbox = useSandbox;
    }

    public Config() {

    }
}
