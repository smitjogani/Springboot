package com.quiz.QuizService.Controller;

import com.quiz.QuizService.Entity.Quiz;
import com.quiz.QuizService.Exception.QuizNotFoundException;
import com.quiz.QuizService.Repository.QuizRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizRepository quizRepository;

    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @GetMapping("/getAll")
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @GetMapping("/getById/{id}")
    public Quiz getQuizById(@PathVariable String id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found with id: " + id));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteQuiz(@PathVariable String id) {
        quizRepository.deleteById(id);
    }
}
