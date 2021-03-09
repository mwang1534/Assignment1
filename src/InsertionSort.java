import java.lang.*;
import java.util.Arrays;

public class InsertionSort {
    private double[] arr;

    public InsertionSort(double [] array) {
        this.arr = array;
    }

    public long insertionSort () {
        long time1 = System.currentTimeMillis();

        for (int i = 1; i < arr.length; i++) { //"i" is the 1st unsorted item
            double temp = arr[i]; //copy
            int j = i-1;
            while (j >= 0 && arr[j] > temp) { //move (loop)
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = temp; //copy back
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }
}
