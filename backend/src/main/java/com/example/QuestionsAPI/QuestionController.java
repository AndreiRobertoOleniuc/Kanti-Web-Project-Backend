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
    ArrayList<Question> questions = new ArrayList<>();

    public QuestionController() {
        AtomicLong counter = new AtomicLong();
        questions.add(new Question(counter.incrementAndGet(), "Hast du spass mit Computer zu arbeiten ?"));
        questions.add(new Question(counter.incrementAndGet(), "Wie läuft es so mit Mathe ?"));
        questions.add(new Question(counter.incrementAndGet(), "Willst du deine Freizeit Opfern ?"));
        questions.add(new Question(counter.incrementAndGet(), "Könntest du dir vorstellen in ein Gebiet einzutauchen welches sich Konstant verändert?"));
        questions.add(new Question(counter.incrementAndGet(), "Würdest du dich eher als eine Person beschrieben welche Lieber seine Arbeit ohne grosse Aktivität durchführt beschrieben?"));
        questions.add(new Question(counter.incrementAndGet(), "Dies könnte zu deinem einzigen Leben werden, willst du das wirklich?"));
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

    @GetMapping("/calculateRate")
    @CrossOrigin(origins = "http://localhost:3000")
    public Answer getCalculation(@RequestParam(value = "answers", defaultValue = "0") String answer) {
        double sum = 0;
        for (int i = 0; i < answer.length(); i++) {
            int a = Integer.parseInt(String.valueOf(answer.charAt(i)));
            sum += a;
        }
        sum /= questions.size() * 4;
        sum *= 100;
        return new Answer(1, Double.toString(sum));
    }
}
