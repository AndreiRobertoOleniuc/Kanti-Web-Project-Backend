/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.QuestionsAPI;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andrei Oleniuc
 */
@RestController
public class QuestionController {

    private static final String template = "%s?";
    private final AtomicLong counter = new AtomicLong();
    ArrayList<Question> questions = new ArrayList<>();

    public QuestionController() {
        questions.add(new Question(1, "Hast du spass mit Computer zu arbeiten ?"));
        questions.add(new Question(2, "Wie läuft es so mit Mathe ?"));
        questions.add(new Question(3, "Willst du deine Freizeit Opfern ?"));
    }

    @GetMapping("/question")
    @CrossOrigin(origins = "http://localhost:3000")
    public Question question(@RequestParam(value = "question", defaultValue = "Wie gehts dir") String question) {
        return new Question(counter.incrementAndGet(), String.format(template, question));
    }

    @GetMapping("/getAllQuestion")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Question> questions() {
        return questions;
    }

    @GetMapping("/getQuestionID")
    @CrossOrigin(origins = "http://localhost:3000")
    public Question getQuestionId(@RequestParam(value = "id", defaultValue = "1") String id) {
        int idQue = Integer.parseInt(id);
        for (Question q : questions) {
            if (idQue == q.getId()) {
                return q;
            }
        }
        return new Question(404, "Question not Found");
    }

}
