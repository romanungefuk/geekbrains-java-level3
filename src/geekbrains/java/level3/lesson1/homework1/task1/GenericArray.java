package geekbrains.java.level3.lesson1.homework1.task1;
import java.lang.reflect.Type;

public class GenericArray<T> {
    private T[] array;


    public GenericArray(T... array) {
        this.array = array;

    }

    public T[] getArray() {
        return array;
    }

    public void changePlaces2ElementsArray(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0) {
            throw new IllegalArgumentException("Индексы элементов массива должны быть больше нуля!");
        } else if (firstIndex > this.array.length - 1 || secondIndex > this.array.length - 1) {
            throw new IllegalArgumentException("Индексы элементов массива не могут быть больше последнего индекса " +
                    "элемента массива!");
        } else {
            T tmp = this.array[firstIndex];
            this.array[firstIndex] = this.array[secondIndex];
            this.array[secondIndex]=tmp;
        }
    }

}

