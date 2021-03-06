package Data_Structure.non_linear;

public class Heap {
    private Heap() {
    }

    public static MaxHeap createMaxHeap(int size) {
        return new MaxHeap(size);
    }

    public static void heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length &&
                array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length &&
                array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException("K must be greater than 1 or less than or equal to the length of the array");

        var heap = Heap.createMaxHeap(array.length);
        for (int item : array)
            heap.insert(item);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }
}
