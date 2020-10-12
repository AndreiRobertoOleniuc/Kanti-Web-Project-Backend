package com.example.Models;

public class TestErgebnis {
    private Long id;
    private String answers;

    public TestErgebnis(Long id, String answers) {
        this.id = id;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
