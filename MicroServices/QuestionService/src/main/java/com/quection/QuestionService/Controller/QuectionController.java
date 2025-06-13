package com.quection.QuestionService.Controller;

import com.quection.QuestionService.Entity.Quection;
import com.quection.QuestionService.Exception.QuectionNotFoundException;
import com.quection.QuestionService.Repository.QuectionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quections")
public class QuectionController {
    private final QuectionRepository quectionRepository;

    public QuectionController(QuectionRepository quectionRepository) {
        this.quectionRepository = quectionRepository;
    }

    @GetMapping("/getAll")
    public List<Quection> getAllQuection() {
        return quectionRepository.findAll();
    }

    @PostMapping("/create")
    public Quection createQuection(@RequestBody Quection quiz) {
        return quectionRepository.save(quiz);
    }

    @GetMapping("/getById/{id}")
    public Quection getQuectionById(@PathVariable String id) {
        return quectionRepository.findById(id)
                .orElseThrow(() -> new QuectionNotFoundException("Quiz not found with id: " + id));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteQuection(@PathVariable String id) {
        quectionRepository.deleteById(id);
    }
}
