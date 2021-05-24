package Lesson3_HW;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitsList = new ArrayList<T>();

    public ArrayList<T> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(ArrayList<T> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public void addFruit(T additionalFruit) {
        fruitsList.add(additionalFruit);
    }

    public void addFruits(T additionalFruit, int n) {
        for (int i = 0; i < n; i++) fruitsList.add(additionalFruit);
    }

    public float calculateBoxWeight() {
        float boxWeight = 0;
        try {
            boxWeight = fruitsList.size() * fruitsList.get(0).getWeight();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Коробка пуста");
        } finally {
            return boxWeight;
        }
    }

    public boolean compare(Box<?> box) {
        return calculateBoxWeight() == box.calculateBoxWeight();
    }

    public void swapFruits(Box<T> box) { //вот тут не получилос поставить мета символ "?"
        if (getClass() == box.getClass()) {
            box.fruitsList.addAll(fruitsList);
            fruitsList.clear();
        } else
            System.out.println("Коробки" + getClass().getName() + " " + box.getClass().getName() + "содержат разные фрукты");
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitsList=" + fruitsList +
                '}';
    }
}
