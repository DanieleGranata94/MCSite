package Classes;

import java.util.ArrayList;

public class Quiz {

    public Quiz (String city)
    {
        this.city=city;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    private String city;
    private ArrayList<Question> questions;
}
