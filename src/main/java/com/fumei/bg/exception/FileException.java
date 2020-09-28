package com.fumei.bg.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zkh
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class FileException extends Exception {
    private static final long serialVersionUID = 4688421823432183191L;
    private Object data;
    public FileException(){
        super();
    }

    public FileException(String message){
        super(message);
    }

    public FileException(String message, Object data){
        super(message);
        this.data = data;
    }

    public FileException(String message,Throwable throwable){
        super(message, throwable);
    }

    public FileException(Throwable throwable){
        super(throwable);
    }
}
