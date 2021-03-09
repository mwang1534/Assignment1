import java.lang.*;
import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    private double[] arr;

    public SelectionSort(double[] array) {
        this.arr = array;
    }

    public long selectionSort () {
        int i = 0, j = 0, smallest = 0;
        double temp = 0.0;
        long time1 = System.currentTimeMillis();

        for (i = 0; i < arr.length - 1; i++)
        {
            smallest = i;
            for (j = i+1; j < arr.length; j++)
            {
                if (arr[j] < arr[smallest])
                    smallest = j;
            }
            temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }

    private static double[] randomDoubles(int size) {
        double[] doublearray = new double[size];

        for (int i = 0; i < size; i++) {
            Random generator = new Random();
            double randomDouble = generator.nextDouble();
            doublearray[i] = randomDouble;
        }
        return doublearray;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort(randomDoubles(5));
        System.out.println(selectionSort.selectionSort());
    }
}
