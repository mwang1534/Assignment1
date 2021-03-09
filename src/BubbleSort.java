import java.lang.*;

public class BubbleSort {
    private double[] arr;

    public BubbleSort(double [] array) {
        this.arr = array;
    }

    public long bubbleSort () {
        double store;
        long time1 = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    store = arr[j+1]; //uses a variable to swap
                    arr[j+1] = arr[j];
                    arr[j] = store;
                }
            }
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }
}
