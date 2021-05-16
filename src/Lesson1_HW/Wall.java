package Lesson1_HW;

public class Wall implements Overcomable {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void sipleOvercome(CanJump jumper) {
        jumper.jump(height);
    }

    @Override
    public void overcome(Competitable competitable) {
        competitable.jump(height);
    }
}
