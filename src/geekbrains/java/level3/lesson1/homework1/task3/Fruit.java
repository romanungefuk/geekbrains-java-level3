package geekbrains.java.level3.lesson1.homework1.task3;

public abstract class Fruit {
    private String name="Фрукт";
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public String getName(){
        return this.name;
    }

    public float getWeight() {
        return weight;
    }
}
