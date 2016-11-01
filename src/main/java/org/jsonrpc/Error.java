package org.jsonrpc;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-01.
 */
public class Error implements Serializable {

    public int code;
    public String message;
    public Object data;

    public Error() {

    }
}
