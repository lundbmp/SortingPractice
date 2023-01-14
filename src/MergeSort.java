public class MergeSort {
    public void sort(int[] array) {
        int length = array.length;

//        Base case: if the array is 1 or 0, the array is sorted so we exit
        if (length < 2) {
            return;
        }

//        Finding midpoint, and initializing the two needed sub arrays, and indexes for population
        int midPoint = length/2;
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[length - midPoint];
        int leftIndex = 0, rightIndex = 0;

//        Populating sub arrays
        for(int i = 0; i < length; i++) {
            if(i < midPoint) {
                leftArray[leftIndex] = array[i];
                leftIndex++;
            } else {
                rightArray[rightIndex] = array[i];
                rightIndex++;
            }
        }

//        sorting the sub arrays
        sort(leftArray);
        sort(rightArray);

//        merging the sub arrays
        merge(array, leftArray, rightArray);
    }

    private void merge(int[] array, int[] leftArray, int[] rightArray) {
//        initialize indexes of the arrays
        int i = 0, j = 0, k = 0;

//        adding and sorting the two array halves to the initial array
        while(i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

//        adding the rest of either array half to the end of array
        while(i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
