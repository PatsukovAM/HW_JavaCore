package Lesson1_HW;

public class Robot implements Competitable {
    private int runDictance, jumpHeight;
    private boolean player;

    public Robot(int runDictance, int jumpHeight) {
        this.runDictance = runDictance;
        this.jumpHeight = jumpHeight;
        player=true;
    }

    @Override
    public void run(int distance) {
        if (player) {
            if (runDictance < distance) {
                player = false;
                System.out.println("робот не пробежал " + distance);
            } else System.out.println("робот пробежал " + distance);
        } else System.out.println("робот выбыл из соревнований");
    }

    @Override
    public void jump(int height) {
        if (player) {
            if (jumpHeight < height) {
                player = false;
                System.out.println("робот не перепрыгнул " + height);
            } else System.out.println("робот перепрыгнул " + height);
        } else System.out.println("робот выбыл из соревнований");
    }
}
