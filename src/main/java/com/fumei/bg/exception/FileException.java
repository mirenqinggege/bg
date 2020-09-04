package com.fumei.bg.exception;


/**
 * @author zkh
 */
public class FileException extends Exception {
    public FileException(){
        super();
    }

    public FileException(String message){
        super(message);
    }

    public FileException(String message,Throwable throwable){
        super(message, throwable);
    }

    public FileException(Throwable throwable){
        super(throwable);
    }
}
