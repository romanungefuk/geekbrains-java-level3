package geekbrains.java.level3.lesson1.homework1.task3;

public class Orange extends Fruit {
    private String name = "Orange";

    public Orange(float weight) {
        super(weight);
    }

    @Override
    public String getName() {
        return name;
    }
}
