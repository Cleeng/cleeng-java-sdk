package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

import java.io.Serializable;

public class BasicResponse extends JSONRPCMessage {

    public Serializable result;
}
