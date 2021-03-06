package geekbrains.java.level3.lesson1.homework1.task3;

import java.util.ArrayList;

public class Box {
    private ArrayList<Fruit> boxArrayList = new ArrayList<>();
    private String fruitType;

    public boolean putFruit(Fruit fruit) {
        boolean result = false;
        if (boxArrayList.isEmpty()) {
            if (fruit instanceof Apple || fruit instanceof Orange) {
                fruitType = fruit.getName();
                boxArrayList.add(fruit);
                result = true;
            } else {
                System.err.println("Есть только коробки для яблок или апельсинов.");
            }

        } else {
            if (this.fruitType.equals(fruit.getName())
                    && this.getBoxArrayList().get(0).getWeight() == fruit.getWeight()) {
                boxArrayList.add(fruit);
                result = true;
            }
        }

        return result;
    }

    public ArrayList<Fruit> getBoxArrayList() {
        return boxArrayList;
    }

    public void deleteAll() {
        this.boxArrayList.clear();
    }

    /**
     * Method calculate the weight of Box if the box is not empty
     * @return the weight of the box
     */
    public float getWeight(){
        float result = 0.0f;
        if(!this.getBoxArrayList().isEmpty()){
            for (Fruit fruit:
            this.getBoxArrayList()) {
                result+=fruit.getWeight();
            }
        }
        return result;
    }
}
