/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Models;

/**
 *
 * @author Andrei Oleniuc
 */
public class Answer {

    private int id;
    private String procent;

    public Answer(int id, String procent) {
        this.id = id;
        this.procent = procent;
    }

    public int getId() {
        return id;
    }

    public String getProcent() {
        return procent;
    }

}
