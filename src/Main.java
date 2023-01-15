import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();

        int[] array = randomArray(100000);

        for (int number:
             array) {
            System.out.print(number + " ");
        }
        System.out.println("\nArray Sorted");
        qs.sort(array, 0, array.length - 1);
        for (int number:
                array) {
            System.out.print(number + " ");
        }
    }

    public static int[] randomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000) + 1;
        }

        return array;
    }
}