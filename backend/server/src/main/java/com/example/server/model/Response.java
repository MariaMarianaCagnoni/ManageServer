package com.example.server.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author mariana
 * @Project: server
 */
public class Response {
    protected LocalDateTime localDateTime;
    protected int statusCode;
    protected HttpStatus status;
    protected  String ReasonOfError;
    protected String message;
}
