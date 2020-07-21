package geekbrains.java.level3.lesson1.homework1.task3;

import com.sun.org.apache.xml.internal.utils.SystemIDResolver;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class MainApplication {

    public static void main(String[] args) {
        Fruit apple1 = new Apple(1.0f);
        Fruit apple2 = new Apple(1.0f);
        Fruit orange1 = new Orange(1.5f);
        Fruit orange2 = new Orange(1.5f);
        Box box1 = new Box();
        Box box2 = new Box();


        //Тест класса Apple
        if (apple2.getName().equals(apple1.getName())
                && (apple2.getWeight() == apple1.getWeight())
                && !orange1.getName().equals(apple1.getName())
                && orange1.getWeight() != apple1.getWeight()) {
            System.out.println("Тест для класса Apple пройден!");
        } else {
            System.out.println("Тест для класса Apple не прошел!");
        }

        //Тест класса Orange
        if (orange2.getName().equals(orange1.getName())
                && (orange2.getWeight() == orange1.getWeight())
                && !apple1.getName().equals(orange1.getName())
                && apple1.getWeight() != orange1.getWeight()) {
            System.out.println("Тест для класса Orange пройден!");
        } else {
            System.out.println("Тест для класса Orange не прошел!");
        }

        //Тест класса Box
        //Тестируем пустой бокс
        if (box1.getBoxArrayList().isEmpty() && box2.getBoxArrayList().isEmpty()) {
            System.out.println("Тест пустых коробок пройден.");
        } else {
            System.out.println("Тест пустых коробок не прошел.");
        }
        //Тестируем добавление в коробки фрукта одного типа
        if (box1.putFruit(apple1) && box1.putFruit(apple2)
                && box2.putFruit(orange1) && box2.putFruit(orange2)) {
            System.out.println("Тест по добавление фруктов одного типа в коропку пройден.");
            box1.deleteAll();
            box2.deleteAll();
            if (box1.getBoxArrayList().isEmpty() && box2.getBoxArrayList().isEmpty()) {
                System.out.println("Тест по удалению всех фруктов из коробки пройден");
            } else {
                System.out.println("Тест по удалению всех фруктов из коробки не прошел.");
            }
        } else {
            System.out.println("Тест по добавление фруктов одного типа в коропку не прошел.");
        }
        //Удостоверяемся что коробки были опустошены для следующего теста
        System.out.println("Размер коробок после теста:");
        System.out.println(box1.getBoxArrayList().size());
        System.out.println(box2.getBoxArrayList().size());
        System.out.println();

        //Тестируем добавление в коробки фруктов разных типов
        if ((box1.putFruit(apple1) && !box1.putFruit(orange1))
                && (box2.putFruit(orange2) && !box2.putFruit(apple2))) {
            System.out.println("Тест по добавлению в коробку разных фруктов пройден.");
            box1.deleteAll();
            box2.deleteAll();
        } else {
            System.err.println("Тест по добавлению в коробку разных фруктов не прошел.");
            box1.deleteAll();
            box2.deleteAll();
        }
        //Удостоверяемся что коробки были опустошены для следующего теста
        System.out.println("Размер коробок после теста:");
        System.out.println(box1.getBoxArrayList().size());
        System.out.println(box2.getBoxArrayList().size());
        System.out.println();

        //Тестируем метод getWeight класса Box
        box1.putFruit(apple1);
        box1.putFruit(apple2);
        box2.putFruit(orange1);
        box2.putFruit(orange2);
        if (box1.getWeight() == 2.0f && box2.getWeight() == 3.0f) {
            System.out.println("Тест метода getWeight класса Box пройден.");
            box1.deleteAll();
            box2.deleteAll();
        } else {
            System.err.println("Тест метода getWeight класса Box не прошел.");
            box1.deleteAll();
            box2.deleteAll();
        }
        //Удостоверяемся что коробки были опустошены для следующего теста
        System.out.println("Размер коробок после теста:");
        System.out.println(box1.getBoxArrayList().size());
        System.out.println(box2.getBoxArrayList().size());
        System.out.println();

        //Тестируем метод compare класса Box
        box1.putFruit(apple1);
        box1.putFruit(apple2);
        box2.putFruit(orange1);
        box2.putFruit(orange2);
        if ((box1.compare(box1) && box2.compare(box2)) && !box1.compare(box2)) {
            System.out.println("Тест сравнения коробок пройден.");
            box1.deleteAll();
            box2.deleteAll();
        } else {
            System.err.println("Тест сравнения коробок не прошел.");
            box1.deleteAll();
            box2.deleteAll();
        }
        //Удостоверяемся что коробки были опустошены для следующего теста
        System.out.println("Размер коробок после теста:");
        System.out.println(box1.getBoxArrayList().size());
        System.out.println(box2.getBoxArrayList().size());
        System.out.println();
    }
}
