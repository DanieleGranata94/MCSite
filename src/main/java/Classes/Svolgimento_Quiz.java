package Classes;

public class Svolgimento_Quiz
{
    private Quiz q;
    private User user;

    public Svolgimento_Quiz(Quiz q,User user)
    {
        this.q=q;
        this.user=user;
    }

    public Quiz getQ() {
        return q;
    }

    public void setQ(Quiz q) {
        this.q = q;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    private int punteggio;
}