import java.lang.*;

public class QuickSort {

    private double[] arr;

    public QuickSort(double [] array) {
        this.arr = array;
    }

    private void quickSort(double [] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            quickSort(arr, left, index-1);
            quickSort(arr, index + 1, right);
        }
    }

    public long sortTime() {
        long time1 = System.currentTimeMillis();
        quickSort(this.arr,0,this.arr.length-1);
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }

    int partition (double[] arr, int left, int right) {
        //Base case -- or reverse of the base case
        if (left < right) {
            int pivot = left;
            int bot = left + 1; //avoids re-sorting the pivot
            int top = right;
            double store;

            while (bot < top) {
                //Count up from bot, down from top, swap ... here:
                while (bot <= right && arr[bot] <= arr[pivot]) {
                    ++bot;
                }
                while (top >= bot && arr[top] > arr[pivot]) {
                    --top;
                }
                if (bot <= right && bot < top) {
                    store = arr[bot];
                    arr[bot] = arr[top];
                    arr[top] = store;
                }
            }
            store = arr[pivot];
            arr[pivot] = arr[top];
            arr[top] = store;

            return top;
        }
        return left;
    }
}
