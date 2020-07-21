package geekbrains.java.level3.lesson1.homework1.task1;

public class MainApplication {

    public static void main(String[] args) {
        GenericArray<Integer> genericArrayInt = new GenericArray<>(1, 2, 3, 4, 5);
        GenericArray<Double> genericArrayDouble = new GenericArray<>(1.0, 2.0, 3.0, 4.0, 5.0);

        //Вывод значений массива целых чисел перед заменой значений двух элементов.
        System.out.println("Массив целых чисел перед заменой элементов:");
        for (int i : genericArrayInt.getArray()) {
            System.out.printf("%d ",i);
        }
        System.out.println();

        genericArrayInt.changePlaces2ElementsArray(0,4); // замена элемента c индексом 0 на с индексом 4 и наоборот

        /*
         *  Вывод значений массива целых чисел после замены значений двух элементов.
         */
        System.out.println("Массив целых чисел после того как элементы поменялись местами:");
        for (int i : genericArrayInt.getArray()) {
            System.out.printf("%d ",i);
        }
        System.out.println();

        //Вывод значений массива вещественнызх чисел перед заменой значений двух элементов.
        System.out.println("Массив вещественных чисел перед заменой элементов:");
        for (double i : genericArrayDouble.getArray()) {
            System.out.printf("%f ",i);
        }
        System.out.println();

        genericArrayDouble.changePlaces2ElementsArray(0,4); // замена элемента c индексом 0 на с индексом 4 и наоборот

        /*
         *  Вывод значений массива вещественных чисел после замены значений двух элементов.
         */
        System.out.println("Массив вещественных чисел после того как элементы поменялись местами:");
        for (double i : genericArrayDouble.getArray()) {
            System.out.printf("%f ",i);
        }

    }


}
