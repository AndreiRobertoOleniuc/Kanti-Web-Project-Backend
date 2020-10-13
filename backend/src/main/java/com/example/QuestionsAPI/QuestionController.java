/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.QuestionsAPI;

import java.util.ArrayList;

import com.example.Models.Answer;
import com.example.Models.Question;
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
    private Logic logic = Logic.getInstance();

    @GetMapping("/question")
    @CrossOrigin(origins = "http://localhost:3000")
    public Question question(@RequestParam(value = "question", defaultValue = "Wie gehts dir") String question) {
        return new Question(1, question);
    }

    @GetMapping("/getAllQuestion")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Question> questions() {
        return logic.getQuestions();
    }

    @GetMapping("/getQuestionID")
    @CrossOrigin(origins = "http://localhost:3000")
    public Question getQuestionId(@RequestParam(value = "id", defaultValue = "1") String id) {
        return logic.getQuestionId(id);
    }

    @GetMapping("/calculateRate")
    @CrossOrigin(origins = "http://localhost:3000")
    public Answer getCalculation(@RequestParam(value = "answers", defaultValue = "0") String answer) {
        return logic.calculateAnswer(answer);
    }
}