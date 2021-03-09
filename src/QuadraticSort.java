public class QuadraticSort {
    //Will replicate inserstion sort because it is the fastest according to the chart and Part 1
    //Requirement 2 & 3
    private double[] arr;
    private int index;

    public QuadraticSort(double [] array) {
        this.arr = array;
        this.index = index;
    }

    public void quadraticSort (double[] arr, int left, int right) {
        for (int i = left+1; i < right+1; i++) { //"i" is the 1st unsorted item
            double temp = arr[i];
            int j = i-1;
            while (j >= left && arr[j] > temp) { //move (loop)
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = temp; //copy back
        }
    }
}
