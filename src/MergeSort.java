import java.lang.*;

public class MergeSort {
    private double[] arr;

    public MergeSort(double [] array) {
        this.arr = array;
    }

    private double[] getLeft (double[] arr) {
        int size = arr.length / 2;
        double [] left = new double[size];
        for (int i = 0; i < size; i++) {
            left[i] = arr[i];
        }
        return left;
    }

    private double[] getRight (double[] arr) {
        int size = arr.length / 2;
        double [] right = new double[size];
        for (int i = 0; i < size; i++) {
            right[i] = arr[i + size];
        }
        return right;
    }

    private void mergeSort(double [] arr) {
        if (arr.length > 1) {
            double [] left = getLeft(arr);
            double [] right = getRight(arr);

            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    public long sortTime() {
        long time1 = System.currentTimeMillis();
        mergeSort(this.arr);
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }

    public void merge (double[] left, double[] right, double[] target) {
        int l = 0;
        int r = 0;
        int t = 0;

        while (t < target.length) {
            if (left[l] < right[r]) {
                target[t++] = left[l++];
            }
            else {
                target[t++] = right[r++];
            }
        }
    }
}
