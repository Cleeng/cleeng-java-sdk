package org.jsonrpc;

import java.io.Serializable;

public class Error implements Serializable {

    public int code;
    public String message;
    public Object data;

    public Error() {

    }
}
