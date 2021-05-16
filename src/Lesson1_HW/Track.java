package Lesson1_HW;

public class Track implements Overcomable {
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    public void simpleOvercome(CanRun runner) {
        runner.run(distance);
    }

    @Override
    public void overcome(Competitable competitable) {
        competitable.run(distance);
    }
}
