package com.cp3.inman.shared;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private int choice;
    private T response;
    public Response(int choice){
        this.choice = choice;
    }
    public int getChoice(){
        return choice;
    }
    public T getResponse(){
        return response;
    }
    public void setResponse(T response){
        this.response = response;
    }
    public void setChoice(int choice){
        this.choice = choice;
    }
}
