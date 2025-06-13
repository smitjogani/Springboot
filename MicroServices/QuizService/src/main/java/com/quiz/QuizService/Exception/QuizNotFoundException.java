package com.quiz.QuizService.Exception;

public class QuizNotFoundException extends RuntimeException{
    public QuizNotFoundException(String message)
    {
        super(message);
    }
}
