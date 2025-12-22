package com.Account.GlobalExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling {
    ///1>Methods()-1
    @ExceptionHandler
    public ResponseEntity<Object>response(NOTFOUNDEXCEPTION notfoundexception){
        EntityException entityException=new EntityException(
                notfoundexception.getMessage(),
                  HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(entityException,HttpStatus.NOT_FOUND) ;
    }

    //2>Method()-2
    @ExceptionHandler
    public ResponseEntity<Object>response(MethodArgumentNotValidException e){
        //create Map to store errors
        Map<String,Object>map=new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((errors)->{
            map.put(errors.getField(),errors.getDefaultMessage());
        });
        return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);

    }
}
