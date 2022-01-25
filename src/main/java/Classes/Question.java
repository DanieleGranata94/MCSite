package Classes;

import java.util.ArrayList;

public class Question
{

    public Question (String question,ArrayList<Reply> replies)
    {
        this.question=question;
        this.replies=replies;
    }

    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Reply> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    private ArrayList<Reply> replies;
}
