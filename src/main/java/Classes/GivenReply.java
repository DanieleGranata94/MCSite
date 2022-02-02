package Classes;

public class GivenReply extends Reply
{
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private String question;
    public GivenReply(String question,String reply, boolean esatto)
    {
        super(reply, esatto);
        this.question=question;
    }

    public GivenReply() {
    }
}
