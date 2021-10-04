import java.util.ArrayList;

public class Student extends Person {
    public ArrayList<Score> scores = new ArrayList<>();

    public double getAverageScore() {
        double sum = 0;
        for (Score score : scores) {
            sum += score.getValue();
        }
        return (sum/scores.size());
    }

    @Override
    public String toString() {
        return ("ID: " + this.id + "\nFirst name: " + this.firstName + "\nLast name: "
                + lastName + "\nmarital status: " + this.status.status + "\nAverage Score: "
                + this.getAverageScore());
    }
}
