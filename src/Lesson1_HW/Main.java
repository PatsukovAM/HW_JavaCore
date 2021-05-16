package Lesson1_HW;

public class Main {
    public static void main(String[] args) {

        Human human1 = new Human(1000, 2);
        Cat cat1 = new Cat(700, 1);
        Robot bot1 = new Robot(3000, 3);

        cat1.run(300);
        human1.run(300);
        bot1.run(300);
        cat1.jump(1);
        human1.jump(1);
        bot1.jump(1);

        cat1.run(1000);
        human1.run(1000);
        bot1.run(1000);
        cat1.jump(2);
        human1.jump(2);
        bot1.jump(2);

        cat1.run(2000);
        human1.run(2000);
        bot1.run(2000);
        cat1.jump(3);
        human1.jump(3);
        bot1.jump(3);

        cat1.run(4000);
        human1.run(4000);
        bot1.run(4000);
        cat1.jump(4);
        human1.jump(4);
        bot1.jump(4);

// вот до сюда мне было все предельно понятно, дальше понятно, но самому до такого дойти пока тяжело

        System.out.println("");

        Competitable[] competitors = {new Cat(700,1), new Human(1000,2), new Robot(3000,3)};
        Overcomable[] barriers = {new Track(800), new Wall(1), new Track(2000), new Wall(4)};

        for (Overcomable overcomable: barriers) {
            for (Competitable competitable: competitors) {
                overcomable.overcome(competitable);
            }
        }
             {

        }
    }
}
