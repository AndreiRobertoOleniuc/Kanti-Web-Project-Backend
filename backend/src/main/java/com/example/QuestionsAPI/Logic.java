package com.example.QuestionsAPI;

import com.example.Models.AddUser;
import com.example.Models.Answer;
import com.example.Models.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Logic {

    private static Logic instance = null;
    private static final String template = "%s?";
    ArrayList<Question> questions = new ArrayList<>();
    private int pageVisited = 0;

    private Logic() {
        AtomicLong counter = new AtomicLong();
        questions.add(new Question(counter.incrementAndGet(), "Example Question 1"));
        questions.add(new Question(counter.incrementAndGet(), "Example Question 2"));
        questions.add(new Question(counter.incrementAndGet(), "Example Question 3"));
        questions.add(new Question(counter.incrementAndGet(), "Example Question 4"));
        questions.add(new Question(counter.incrementAndGet(), "Example Question 5"));
        questions.add(new Question(counter.incrementAndGet(), "Example Question 6"));
    }

    public static Logic getInstance() {
        if (instance == null) {
            instance = new Logic();
        }
        return instance;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public Question getQuestionId(String id){
        int idQue = Integer.parseInt(id);
        for(Question q : questions){
            if(q.getId()==idQue){
                return q;
            }
        }
        return new Question(1,"404 Question not found");
    }

    public Answer calculateAnswer(String answer){
        double sum = 0;
        for (int i = 0; i < answer.length(); i++) {
            int a = Integer.parseInt(String.valueOf(answer.charAt(i)));
            sum += a;
        }
        sum /= questions.size() * 4;
        sum *= 100;
        return new Answer(1, Double.toString(sum));
    }

    public String addVisitor(AddUser add){
        try{
            pageVisited+=add.getAdd();
            return "Ok";
        }catch (Error e){
            return "Bad";
        }
    }
    public int getVisitors(){
        return pageVisited;
    }

}
