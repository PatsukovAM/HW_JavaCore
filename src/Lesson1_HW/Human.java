package Lesson1_HW;

public class Human implements Competitable {
    private int runDictance, jumpHeight;
    private boolean player;

    public Human(int runDictance, int jumpHeight) {
        this.runDictance = runDictance;
        this.jumpHeight = jumpHeight;
        player=true;
    }

    @Override
    public void run(int distance) {
        if (player == true) {
            if (runDictance < distance) {
                player = false;
                System.out.println("человек не пробежал " + distance);
            } else System.out.println("человек пробежал " + distance);
        } else System.out.println("человек выбыл из соревнований");
    }

    @Override
    public void jump(int height) {
        if (player == true) {
            if (jumpHeight < height) {
                player = false;
                System.out.println("человек не перепрыгнул " + height);
            } else System.out.println("человек перепрыгнул " + height);
        } else System.out.println("человек выбыл из соревнований");
    }
}
