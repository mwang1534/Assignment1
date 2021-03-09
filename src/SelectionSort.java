import java.lang.*;

public class SelectionSort {
    private double[] arr;

    public SelectionSort(double [] array) {
        this.arr = array;
    }


    private int findSmallest (double [] arr, int start) {
        int smallest = start; //assume first item is smallest for if statement
        for (int i = start+1; i < arr.length-1; i++) {
            if (arr[i] < arr[smallest]) {
                smallest = i;
                return smallest;
            }
        }
        return smallest;
    }

    public long selectionSort () {
        double store;
        int swap;
        long time1 = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            store = arr[i]; //stores first element of unsorted section of array
            swap = findSmallest(arr, i); //gets index of smallest element in unsorted array
            arr[i] = arr[swap]; //sets first index of unsorted array to smallest element
            arr[swap] = store; //sets index of smallest element to stored element
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }
}
