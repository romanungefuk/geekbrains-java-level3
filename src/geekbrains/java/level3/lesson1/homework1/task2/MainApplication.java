package geekbrains.java.level3.lesson1.homework1.task2;

import geekbrains.java.level3.lesson1.homework1.task1.GenericArray;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApplication {

    public static void main(String[] args) {

        //generate first one array as type string
        String[] arrayString = new GenericArray<String>("one", "two", "three", "four", "five").getArray();
        //generate first one array as type Integer
        Integer[] arrayInt = new GenericArray<Integer>(1, 2, 3, 4, 5).getArray();

        //get first ArrayList from array
        ArrayList<?> arList1 = convertArrayToArrayList(arrayString);
        //list the elements from ArrayList
        for (int i = 0; i < arList1.size(); i++) {
            System.out.print(arList1.get(i) + " ");
        }
        System.out.println();

        //get second ArrayList from array
        ArrayList<?> arList2 = convertArrayToArrayList(arrayInt);
        //list the elements from ArrayList
        for (int i = 0; i < arList2.size(); i++) {
            System.out.print(arList2.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * The method convert array to ArrayList
     * @param array the parameter have to be an array from any type
     * @return ArrayList from the type of array
     */
    public static ArrayList<?> convertArrayToArrayList(Object... array) {
        return new ArrayList<>(Arrays.asList(array));
    }

}

