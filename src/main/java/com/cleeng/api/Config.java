package com.cleeng.api;

public class Config {

    public int socketTimeout = -1;
    public int connectionTimeout = -1;
    public int retryCount = 0;
    public boolean useNonBlockingMode = false;

    public Config(int socketTimeout, int connectionTimeout, int retryCount, boolean useNonBlockingMode) {
        this.socketTimeout = socketTimeout;
        this.connectionTimeout = connectionTimeout;
        this.retryCount = retryCount;
        this.useNonBlockingMode = useNonBlockingMode;
    }
}
