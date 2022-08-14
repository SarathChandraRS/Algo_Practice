public class Search {

    public static void main(String args[]) {
        Search ob = new Search();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

    public int binarySearch(int[] a, int start, int end, int x) {
        if (end >=start) {
            int m = (start + end) / 2;
            if (x == a[m]) {
                return m;
            } else if (x < a[m]) {
                return binarySearch(a, start, m - 1, x);
            } else {
                return binarySearch(a, m + 1, end, x);
            }
        }

        return -1;
    }
}
