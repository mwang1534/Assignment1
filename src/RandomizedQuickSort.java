import java.util.Random;
import java.util.Scanner;

public class RandomizedQuickSort {

    private double[] arr;

    public RandomizedQuickSort(double[] array) {
        this.arr = array;
    }

    public int randomquicksort (double[] arr, int left, int right) {
        if (left < right) {
            int index = partition(this.arr, left, right);
//            randomquicksort(arr, left, index-1);
//            randomquicksort(arr, index + 1, right);
            return index;
        }
        return 0;
    }

    int partition (double[] arr, int left, int right) {
        //Base case -- or reverse of the base case
        if (left < right) {
            Random generator = new Random();
            int pivot = generator.nextInt(arr.length);
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

    public static void main(String[] args) {
        RandomizedQuickSort randomizedQuickSort = new RandomizedQuickSort(new double[]{5, 2, 9, 12, 6, 8, 3, 7});
        //randomizedQuickSort.randomquicksort();
    }
}
