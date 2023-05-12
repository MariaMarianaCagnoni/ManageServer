package com.example.server.enumeration;

import lombok.Getter;

/**
 * @author mariana
 * @Project: server
 */
@Getter
public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;

    Status(String status){
        this.status = status;
    }
}
