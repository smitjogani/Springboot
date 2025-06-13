package com.quection.QuestionService.Exception;

public class QuectionNotFoundException extends RuntimeException{
    public QuectionNotFoundException(String message)
    {
        super(message);
    }
}
