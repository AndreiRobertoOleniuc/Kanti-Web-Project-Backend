package com.example.QuestionsAPI;

import com.example.Models.AddUser;
import com.example.Models.Answer;
import com.example.Models.Question;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Repository {

    private static Repository instance = null;
    private static final String template = "%s?";
    ArrayList<Question> questions = new ArrayList<>();
    private int pageVisited = 0;

    private Repository() {
        AtomicLong counter = new AtomicLong();
        questions.add(new Question(counter.incrementAndGet(), "Hast du spass mit Computer zu arbeiten ?"));
        questions.add(new Question(counter.incrementAndGet(), "Wie läuft es so mit Mathe ?"));
        questions.add(new Question(counter.incrementAndGet(), "Willst du deine Freizeit Opfern ?"));
        questions.add(new Question(counter.incrementAndGet(), "Könntest du dir vorstellen in ein Gebiet einzutauchen welches sich Konstant verändert?"));
        questions.add(new Question(counter.incrementAndGet(), "Würdest du dich eher als eine Person beschrieben welche Lieber seine Arbeit ohne grosse Aktivität durchführt beschrieben?"));
        questions.add(new Question(counter.incrementAndGet(), "Dies könnte zu deinem einzigen Leben werden, willst du das wirklich?"));
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
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
