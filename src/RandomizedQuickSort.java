import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomizedQuickSort {
    //Requirement 1

    private double[] arr;

    public RandomizedQuickSort(double[] array) {
        this.arr = array;
    }

    public int randomquicksort (double[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            randomquicksort(arr, left, index-1);
            randomquicksort(arr, index + 1, right);
            return index;
        }
        return 0;
    }

    public void hybridsort (double[] arr, int left, int right) {
        if (right - left > 1000) {
            int partition = randomquicksort(arr, left, right);
            if (partition - left < 1000) {
                QuadraticSort quadraticSort = new QuadraticSort(arr);
                quadraticSort.quadraticSort(arr, left, partition-1);
            }
            else {
                hybridsort(arr, left, partition-1);
            }
            if (right - partition < 1000) {
                QuadraticSort quadraticSort = new QuadraticSort(arr);
                quadraticSort.quadraticSort(arr, partition+1, right);
            }
            else {
                hybridsort(arr, partition+1, right);
            }
        }
        else {
            QuadraticSort quadraticSort = new QuadraticSort(arr);
            quadraticSort.quadraticSort(arr, left, right);
        }
    }

    int partition (double[] arr, int left, int right) {
        //Base case -- or reverse of the base case
        if (left < right) {
            Random generator = new Random();
            int pivot = generator.nextInt(right-left) + left;
            int bot = left; //avoids re-sorting the pivot
            int top = right;
            double store;

            while (bot < top) {
                //Count up from bot, down from top, swap ... here:
                while (bot <= right && arr[bot] <= arr[pivot]) {
                    ++bot;
                }
                while (top >= bot && arr[top] >= arr[pivot]) {
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

    private static double[] randomDoubles(int size) {
        double[] doublearray = new double[size];

        for (int i = 0; i < size; i++) {
            Random generator = new Random();
            double randomDouble = generator.nextDouble();
            doublearray[i] = randomDouble;
        }
        return doublearray;
    }

    public static boolean isSorted(double[] arr) { //for testing if the hybridsort works
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of the double array (must be a multiple of 50,000!): ");;
        int size = input.nextInt();
        RandomizedQuickSort randomizedQuickSort = new RandomizedQuickSort(randomDoubles(size));
        int index = randomizedQuickSort.randomquicksort(randomizedQuickSort.arr, 0,
                randomizedQuickSort.arr.length-1);
        System.out.println(isSorted(randomizedQuickSort.arr));
        //System.out.println(index);

//        randomizedQuickSort.hybridsort(randomizedQuickSort.arr, 0, randomizedQuickSort.arr.length-1);
//        System.out.println(Arrays.toString(randomizedQuickSort.arr));
//        System.out.println(isSorted(randomizedQuickSort.arr));
    }
}
