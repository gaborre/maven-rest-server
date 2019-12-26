/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.utils;

/**
 *
 * @author german
 */
public class Response {
    
    private int code;
    private String message;
    private Object content;
    
    public Response(int code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    /**
     * Get the value of content
     *
     * @return the value of content
     */
    public Object getContent() {
        return content;
    }

    /**
     * Set the value of content
     *
     * @param content new value of content
     */
    public void setContent(Object content) {
        this.content = content;
    }


    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * Get the value of code
     *
     * @return the value of code
     */
    public int getCode() {
        return code;
    }

    /**
     * Set the value of code
     *
     * @param code new value of code
     */
    public void setCode(int code) {
        this.code = code;
    }
    
    /**
     *
     * @param code
     * @param message
     * @param content
     * @return
     */
    public static Response getResponse(int code, String message, Object content) {
        return new Response(code, message, content);
    }
}
