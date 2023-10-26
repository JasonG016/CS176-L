package interfaceV1;

public class Quiz implements Measurable {
    private int score;

    public Quiz(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public double getMeasure() {
        return score;
    }
}