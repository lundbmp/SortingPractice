public class QuickSort {
    public void sort(int[] array, int lowIndex, int highIndex) {
//      Base case: when have an array segment of 1
        if (lowIndex >= highIndex) {
            return;
        }

//      Initializing our pivot (highest index), left pointer, and right pointer
        int pivot = array[highIndex];
        int lp = lowIndex;
        int rp = highIndex;

//       sorting the array where values lower than our pivot are swapped to the left and higher are swapped to the right
        while (lp < rp) {
//           starting from the beginning of the array, finding a value that is higher than the pivot then stop
            while (array[lp] <= pivot && lp < rp) {
                lp++;
            }
//           starting from the end of the array, finding a value that is lower than the pivot then stop
            while (array[rp] >= pivot && lp < rp) {
                rp--;
            }
//           swapping the lower and higher value
            swap(array, lp, rp);
        }
//        swapping the pivot with where the left pointer ends (where lp == rp)
        swap(array, lp, highIndex);

//        left side sort, low index being the beginning and high index being 1 index lower than the previous pivot
        sort(array, lowIndex, lp - 1);
//        right side sort, low index being one index higher than the pivot and high index being the end of the array
        sort(array, lp + 1, highIndex);
    }

//    swapping two indexes of an array
    private void swap(int[] array, int lp, int rp) {
        int temp = array[rp];
        array[rp] = array[lp];
        array[lp] = temp;
    }
}
