import java.util.Arrays;

public class Problem2 {
    static class Stats {
        int comparisons = 0;
        int swapsOrMoves = 0;
        int maxDepth = 0;
    }

    // ---------- Merge Sort ----------
    public static void mergeSort(int[] arr, Stats stats) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1, 1, stats);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right, int depth, Stats stats) {
        stats.maxDepth = Math.max(stats.maxDepth, depth);
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, temp, left, mid, depth + 1, stats);
        mergeSort(arr, temp, mid + 1, right, depth + 1, stats);
        merge(arr, temp, left, mid, right, stats);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right, Stats stats) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            stats.comparisons++;
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
            stats.swapsOrMoves++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
            stats.swapsOrMoves++;
        }

        while (j <= right) {
            temp[k++] = arr[j++];
            stats.swapsOrMoves++;
        }

        for (int p = left; p <= right; p++) {
            arr[p] = temp[p];
            stats.swapsOrMoves++;
        }
    }

    // ---------- Quick Sort ----------
    public static void quickSort(int[] arr, Stats stats) {
        quickSort(arr, 0, arr.length - 1, 1, stats);
    }

    private static void quickSort(int[] arr, int low, int high, int depth, Stats stats) {
        if (low > high) return;
        stats.maxDepth = Math.max(stats.maxDepth, depth);
        if (low >= high) return;

        int pi = partition(arr, low, high, stats);
        quickSort(arr, low, pi - 1, depth + 1, stats);
        quickSort(arr, pi + 1, high, depth + 1, stats);
    }

    private static int partition(int[] arr, int low, int high, Stats stats) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            stats.comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j, stats);
            }
        }

        swap(arr, i + 1, high, stats);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j, Stats stats) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        stats.swapsOrMoves++;
    }

    private static int[] copy(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    private static void runTest(String name, int[] input) {
        int[] a = copy(input);
        int[] b = copy(input);

        Stats mergeStats = new Stats();
        Stats quickStats = new Stats();

        mergeSort(a, mergeStats);
        quickSort(b, quickStats);

        System.out.println("Dataset: " + name);
        System.out.println("Input      : " + Arrays.toString(input));
        System.out.println("Merge Sort : " + Arrays.toString(a));
        System.out.println("  comparisons=" + mergeStats.comparisons
                + ", moves=" + mergeStats.swapsOrMoves
                + ", depth=" + mergeStats.maxDepth);

        System.out.println("Quick Sort : " + Arrays.toString(b));
        System.out.println("  comparisons=" + quickStats.comparisons
                + ", swaps=" + quickStats.swapsOrMoves
                + ", depth=" + quickStats.maxDepth);
        System.out.println();
    }

    public static void main(String[] args) {
        runTest("Random", new int[]{5, 1, 8, 3, 2, 7, 4, 6});
        runTest("Already sorted", new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        runTest("Reverse sorted", new int[]{8, 7, 6, 5, 4, 3, 2, 1});
        runTest("Many duplicates", new int[]{4, 2, 4, 1, 4, 2, 1, 4});
    }
}