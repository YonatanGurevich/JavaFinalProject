public class Score {
    private String course;
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double v) {
        this.value = v;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String name) {
        this.course = name;
    }
}
