

import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException("Null argument");
        int first = -1;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(key, a[mid]) == 0) {
                if (mid == 0) return 0;
                if (comparator.compare(a[mid - 1], key) == 0) {
                    first = mid - 1;
                    hi = mid - 1;
                }
                else {
                    first = mid;
                    break;
                }
            }
            else if (comparator.compare(key, a[mid]) < 0) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
        }
        return first;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null)
            throw new IllegalArgumentException("Null argument");
        int last = -1;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (comparator.compare(key, a[mid]) == 0) {
                if (mid == a.length - 1) return a.length - 1;
                if (comparator.compare(a[mid + 1], key) == 0) {
                    last = mid + 1;
                    lo = mid + 1;
                }
                else {
                    last = mid;
                    break;
                }
            }
            else if (comparator.compare(key, a[mid]) < 0) {
                hi = mid - 1;
            }

            else {
                lo = mid + 1;
            }
        }
        return last;
    }


    public static void main(String[] args) {
        String[] a = { "A", "A", "C", "G", "G", "T" };
        int index = BinarySearchDeluxe.firstIndexOf(a, "C", String.CASE_INSENSITIVE_ORDER);
        StdOut.println(index);
    }
}
