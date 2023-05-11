package sort.selection;

import sort.Sort;

public class ShellSort implements Sort {

    public void sort(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = arr.length / 2; i > 0; i = i / 2) {
            insertSort(arr, i);
        }

    }


    private void insertSort(int[] arr, int groupSize) {
        for (int i = groupSize; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            for (; j >= groupSize && temp < arr[j - groupSize]; j = j - groupSize) {
                arr[j] = arr[j - groupSize];
            }
            arr[j] = temp;
        }
    }

}
