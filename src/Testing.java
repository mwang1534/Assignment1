import java.util.Scanner;
import java.util.Random;

public class Testing {

    private static double[] randomDoubles(int size) {
        double[] doublearray = new double[size];

        for (int i = 0; i < size; i++) {
            Random generator = new Random();
            double randomDouble = generator.nextInt();
            doublearray[i] = randomDouble;
        }
        return doublearray;
    }

    private static void runSorting(int size) {
        int i = 50000;

        while (i <= size) {
            InsertionSort insertionsort = new InsertionSort(randomDoubles(i));
            BubbleSort bubblesort = new BubbleSort(randomDoubles(i));
            SelectionSort selectionsort = new SelectionSort(randomDoubles(i));
            QuickSort quicksort = new QuickSort(randomDoubles(i));
            MergeSort mergeSort = new MergeSort(randomDoubles(i));

            System.out.println("Sort Round: " + (i/50000));
            System.out.println("Insertion Sort time: " + insertionsort.insertionSort());
            System.out.println("Bubble Sort time: " + bubblesort.bubbleSort());
            System.out.println("Selection Sort time: " + selectionsort.selectionSort());
            System.out.println("Quick Sort time: " + quicksort.sortTime());
            System.out.println("Merge Sort time: " + mergeSort.sortTime());

            i += 50000;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of the double array (must be a multiple of 50,000!): ");;
        int size = input.nextInt();
        runSorting(size);
    }
}

// loop where x arrays, x - 50000*i > 0
// create array
// sort array
// print runtimes
