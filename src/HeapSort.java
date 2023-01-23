// https://www.youtube.com/watch?v=HqPJF2L5h9U&ab_channel=AbdulBari
// this was an excellent explanation, highly recommend

public class HeapSort {
    public void sort(int[] array) {
        int size = array.length;

//        the given input cannot be assumed to be in a heap structure, so we must heapify the array
        for(int i = size/2; i >= 0; i-- ) {
            heapify(array, size, i);
        }

//        once the array is a heap, we start at the back of the array and place the largest value at i
//        we then call heapify to reheapify the array with a heap size reduced by 1, leaving the value placed
//        at i outside the heap

        for(int i = size - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int size, int index) {
//        we set the parent node initially as the largest
        int largest = index;
//        the left child is found in the array with 2 * parents index + 1
        int lChild = 2 * index + 1;
        //        the right child is found in the array with 2 * parents index + 2
        int rChild = 2 * index + 2;

//        check the left and right children to see if they are larger than the parent
        if (lChild < size && array[lChild] > array[largest]) {
            largest = lChild;
        }

        if (rChild < size && array[rChild] > array[largest]) {
            largest = rChild;
        }

//        if the largest changed from the parent, we then perform a swap on the two indices
        if (largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;

//            recursively heapify the subtree of the affected nodes
            heapify(array, size, largest);
        }
    }
}
