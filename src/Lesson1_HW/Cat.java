package Lesson1_HW;

public class Cat implements Competitable {
    private int runDictance, jumpHeight;
    private boolean player;

    public Cat(int runDictance, int jumpHeight) {
        this.runDictance = runDictance;
        this.jumpHeight = jumpHeight;
        player=true;
    }

    @Override
    public void run(int distance) {
        if (player) {
            if (runDictance < distance) {
                player = false;
                System.out.println("кот не пробежал " + distance);
            } else System.out.println("кот пробежал " + distance);
        } else System.out.println("кот выбыл из соревнований");
    }

    @Override
    public void jump(int height) {
        if (player) {
            if (jumpHeight < height) {
                player = false;
                System.out.println("кот не перепрыгнул " + height);
            } else System.out.println("кот перепрыгнул " + height);
        } else System.out.println("кот выбыл из соревнований");
    }
}
