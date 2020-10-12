/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.QuestionsAPI;

/**
 *
 * @author Andrei Oleniuc
 */
public class Question {

    private final long id;
    private final String question;

    public Question(long id, String question) {
        this.id = id;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

}
