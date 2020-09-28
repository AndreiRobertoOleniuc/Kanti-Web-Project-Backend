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

    @GetMapping("/question")
    @CrossOrigin(origins = "http://localhost:3000")
    public Question question(@RequestParam(value = "question", defaultValue = "Wie gehts dir") String question) {
        return new Question(counter.incrementAndGet(), String.format(template, question));
    }

    @GetMapping("/getAllQuestion")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Question> questions() {
        ArrayList<Question> que = new ArrayList<>();
        que.add(new Question(counter.incrementAndGet(), "Hast du spass mit Computer zu arbeiten ?"));
        que.add(new Question(counter.incrementAndGet(), "Wie läuft es so mit Mathe ?"));
        que.add(new Question(counter.incrementAndGet(), "Willst du deine Freizeit Opfern ?"));
        return que;
    }
}
